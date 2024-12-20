(defproject hgp.ass370/ASS370-ONJVM "1.0.0-SNAPSHOT" ; version "1.0.0-SNAPSHOT
  :description "A 370 / 390 Assembler"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :main hgp.ass370/ass-main
  :dependencies
  [[org.clojure/clojure "1.11.1"]
   [org.ow2.asm/asm "9.6"]
   [org.ow2.asm/asm-commons "9.6"]
   [org.ow2.asm/asm-util "9.6"]
   [org.ow2.asm/asm-tree "9.6"]
   [org.ow2.asm/asm-analysis "9.6"]
   [org.clojure/core.async "1.6.681"]
   [de.active-group/active-clojure "0.42.2"]
   [de.active-group/active-data "0.2.1"]
   [clojure-interop/apache-commons-io "1.0.0"]
   [com.ibm.icu/icu4j "75.1"]
   [com.ibm.icu/icu4j-charset "75.1"]
   [clojure-lanterna "0.9.8"]
   [ hgp.genbytec/JVMByteCodeGenerator "1.0.0-SNAPSHOT"]]
  :source-paths ["src"]
  :java-source-paths ["src/main/java"]                      ; Java source is stored separately.
  :test-paths ["test/clj"]
  :resource-paths ["resource"]
  :dev {:resource-paths "test/resource"}


  :clean-targets ^{:protect false} ["resources/public/js/compiled"
                                    "resources/public/cljs-out" :target-path]
  :aot :all
  :jar-exclusions [#"(?:^|/).svn/.idea"]
  :jar-inclusions [#"(?:^|/)\.ebextensions"]

  )
