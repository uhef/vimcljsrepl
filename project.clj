(defproject vimcljsrepl "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.5.0"
  :source-paths ["src/clj" "src/cljs"]
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [org.clojure/clojurescript "0.0-3291" :scope "provided"]
                 [compojure "1.3.4"]
                 [ring/ring-defaults "0.1.2"]
                 [ring/ring-jetty-adapter "1.3.2"]
                 [ring/ring-devel "1.3.2"]]
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler vimcljsrepl.handler/app}
  :profiles
  {:dev {:dependencies [[weasel "0.7.0"]]}})
