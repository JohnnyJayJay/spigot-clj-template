(ns {{namespace}}
  (:gen-class
    :name {{package}}.{{class}}
    :extends {{package}}.ClojurePlugin)
  (:import (org.bukkit.command CommandSender)
           (org.bukkit.plugin.java JavaPlugin)))

(set! *warn-on-reflection* true)

(defn -onEnable [^JavaPlugin this]
  (.. this (getLogger) (info "Clojure Plugin {{name}} enabled!")))

(defn -onCommand [this ^CommandSender sender command label args]
  (.sendMessage sender "Hello from Clojure!"))

