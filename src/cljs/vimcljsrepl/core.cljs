(ns vimcljsrepl.core
  (:require [weasel.repl :as weasel]))

(weasel/connect "ws://localhost:9001" :verbose true)
