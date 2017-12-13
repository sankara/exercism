(ns rna-transcription)

(def ^:const dna-rna-mapping {
                              \G \C,
                              \C \G,
                              \T \A,
                              \A \U
                              })

(defn- transcribe [nucleotide]
  (get dna-rna-mapping nucleotide))
  
(defn to-rna [sequence]
  (assert (re-matches #"[GCTA]*" sequence))
  (apply str (map transcribe sequence)))
