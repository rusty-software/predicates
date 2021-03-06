(ns predicates)

(defn sum-f [f g x]
  (+ (f x) (g x)))

(defn less-than [n]
  (fn [v] (< v n)))

(defn equal-to [n]
  (fn [v] (== v n)))

(defn set->predicate [a-set]
  (fn [x] (contains? a-set x)))

(defn pred-and [pred1 pred2]
  (fn [x] (and (pred1 x) (pred2 x))))

(defn pred-or [pred1 pred2]
  (fn [x] (or (pred1 x) (pred2 x))))

(defn whitespace? [character]
  (Character/isWhitespace character))

(defn blank? [string]
  (or (nil? string)
      (empty? string)
      (= (seq string) (filter whitespace? string))))

(defn has-award? [book award]
  (not (nil? (award (:awards book)))))

(defn HAS-ALL-THE-AWARDS? [book awards]
  (= (seq awards) (seq (filter (:awards book) awards))))

(defn my-some [pred a-seq]
  (let [vals (filter pred a-seq)]
    (if (seq vals)
      (pred (first vals))
      false)))

(defn my-every? [pred a-seq]
  (if (seq a-seq)
    (let [vals-set (into #{} (map pred a-seq))]
      (and (= 1 (count vals-set))
           (first vals-set)))
    true))

(defn prime? [n]
  (let [divides-evenly? (fn [cur] (= 0 (mod n cur)))]
    (not (some divides-evenly? (range 2 n)))))
;^^
