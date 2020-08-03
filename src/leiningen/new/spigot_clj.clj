(ns leiningen.new.spigot-clj
  (:require [clojure.string :refer [split]]
            [leiningen.new.templates
             :refer [renderer name-to-path ->files multi-segment sanitize-ns project-name sanitize]]
            [leiningen.core.main :as main]))

(def render (renderer "spigot-clj"))

(defn- capitalize [s]
  (str (Character/toUpperCase ^char (first s))
     (subs s 1)))

(defn- sanitize-class [name]
  (as-> name $
        (project-name $)
        (split $ #"_+")
        (map capitalize $)
        (apply str $)))

(defn spigot-clj
  "Creates a Clojure spigot template"
  [name]
  (let [data {:name        name
              :simple-name (project-name name)
              :package     (sanitize (sanitize-ns name))
              :class       (sanitize-class name)
              :namespace   (multi-segment (sanitize-ns name) "plugin")
              :sanitized   (name-to-path name)}]
    (main/info "Generating fresh 'lein new' spigot-clj project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["resources/plugin.yml" (render "plugin.yml" data)]
             ["src/java/{{sanitized}}/ClojurePlugin.java" (render "ClojurePlugin.java" data)]
             ["src/clojure/{{sanitized}}/plugin.clj" (render "plugin.clj" data)]
             [".gitignore" (render ".gitignore")]
             [".hgignore" (render ".hgignore")]
             ["LICENSE" (render "LICENSE")]
             ["README.md" (render "README.md" data)])))
