(ns lobshop.inject.core
  (:require
    [dommy.core :as dommy :refer-macros [sel sel1]]
    [crate.core :refer [html]]))

(.. js/document (addEventListener "DOMContentLoaded"
 #(-> (sel1 :.dropdown-sort)
    (dommy/append! (html
                    [:li {} [:button {:class "btn btn-link btn-sort-link"} "Price/Weight"]])
                   (html
                    [:li {} [:button {:class "btn btn-link btn-sort-link"} "Discount %"]])))))

