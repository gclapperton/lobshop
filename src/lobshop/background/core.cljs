(ns lobshop.background.core)

(defn on-installed [f]
  (.. js/chrome -runtime -onInstalled
      (addListener f)))

(defn remove-rules [rules callback]
  (.. js/chrome -declarativeContent -onPageChanged
      (removeRules rules callback)))

(defn add-rules [rules]
  (.. js/chrome -declarativeContent -onPageChanged
      (addRules rules)))

(defn url-matches [scheme host]
  (.. js/chrome -declarativeContent
      (PageStateMatcher. {:pageUrl {:hostEquals host :schemes [scheme]}})))

(defn showPageAction []
  (.. js/chrome -declarativeContent
      (ShowPageAction.)))

(defn inject [content]
  (.. js/chrome -declarativeContent
      (RequestContentScript. content)))

(->> [{:conditions [(url-matches "https" "shop.loblaws.ca")]
	     :actions [(showPageAction) (inject {:js ["inject.js"]})]}]
     (partial add-rules)
     (partial remove-rules nil)
     on-installed)
