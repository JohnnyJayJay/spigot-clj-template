(defproject {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :repositories [["spigotmc" "https://hub.spigotmc.org/nexus/content/repositories/snapshots/"]
                 ["snapshots" "https://oss.sonatype.org/content/repositories/snapshots"]]
  :dependencies [[org.clojure/clojure "1.10.1"]]
  :source-paths ["src/clojure"]
  :java-source-paths ["src/java"]
  :profiles {:provided {:dependencies [[org.spigotmc/spigot-api "1.16.1-R0.1-SNAPSHOT" :scope "runtime"]]}}
  :repl-options {:init-ns test.core}
  :aot :all)
