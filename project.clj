(defproject lobshop "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2657"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [om "0.8.0-rc1"]
                 [prismatic/dommy "1.0.0"]
                 [crate "0.2.5"]]

  :plugins [[lein-cljsbuild "1.0.4"]]

  :clean-targets ["extension/out" "background.js" "popup.js" "inject.js"]

  :cljsbuild {
    :builds [{:id "background"
              :source-paths ["src/lobshop/background"]
              :compiler {
                :output-to "extension/background.js"
                :source-map "extension/background.js.map"
                :output-dir "extension/out/background"
                :optimizations :whitespace
                :cache-analysis true}}
             {:id "popup"
              :source-paths ["src/lobshop/popup"]
              :compiler {
                :output-to "extension/popup.js"
                :source-map "extension/popup.js.map"
                :output-dir "extension/out/popup"
                :optimizations :whitespace
                :cache-analysis true}}
             {:id "inject"
              :source-paths ["src/lobshop/inject"]
              :compiler {
                :output-to "extension/inject.js"
                :source-map "extension/inject.js.map"
                :output-dir "extension/out/inject"
                :optimizations :whitespace
                :cache-analysis true}}]})
