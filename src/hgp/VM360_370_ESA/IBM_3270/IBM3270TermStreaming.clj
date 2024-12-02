(ns hgp.VM360-370-ESA.IBM-3270.IBM3270TermStreaming
  (:import (java.io InputStream)))

(defn read-3270stream-proxy
  (let [stream-read-proxy (proxy [InputStream] []
                            (read
                              ([] 1)
                              ([^bytes bytes] 2)
                              ([^bytes bytes off len]
                               ())))]))


