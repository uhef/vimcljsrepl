(ns vimcljsrepl.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [cljs.build.api :refer [build]]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.reload :refer [wrap-reload]]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn run []
  (cljs.build.api/build "src/cljs" {:optimizations :none
                                    :pretty-print true
                                    :source-map true
                                    :main "vimcljsrepl.core"
                                    :asset-path "js/out"
                                    :output-to "resources/public/js/main.js"
                                    :output-dir "resources/public/js/out"})
  (run-jetty (wrap-reload #'app '(vimcljsrepl.handler)) {:port 8080 :join? false}))
