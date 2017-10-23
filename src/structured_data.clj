(ns structured-data)

(defn do-a-thing [x]
 (let [dx (+ x x)]
   (Math/pow dx dx)))

(defn spiff [v]
 (+ (get v 0) (get v 2)))

(defn cutify [v]
 ( conj v "<3"))

(defn spiff-destructuring [v]
 (+ (first v)(nth v 2))) 

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
 (let [[[x1 y1][x2 y2]] rectangle]
   (- x2 x1)))  

(defn height [rectangle]
  (let [[[x1 y1][x2 y2]] rectangle]
   (- y2 y1))) 

(defn square? [rectangle]
  ( = (height rectangle) (width rectangle)))

(defn area [rectangle]
  ( * (height rectangle) (width rectangle)))

(defn contains-point? [rectangle point]
  (let [[[x1 y1][x2 y2]] rectangle  [px py] point]
    (cond
      (and (<= y1 py y2)(<= x1 px x2)) true
      :else false)))

(defn contains-rectangle? [outer inner]
 (let [[[x1 y1] [x2 y2]] inner]
   (and (contains-point? outer (point x1 y1))
        (contains-point? outer (point x2 y2)))))

(defn title-length [book]
  (count (:title book))) 

(defn author-count [book]
  (count (:authors book)))

(defn multiple-authors? [book]
 (cond
   (> (count (:authors book)) 1)
      true
      :else false))

(defn add-author [book new-author]
(assoc book :authors (conj (:authors book)new-author)))

(defn alive? [author]
 (cond
   (contains? author :death-year) false
   :else true))

(defn element-lengths [collection]
  (map count collection))

(defn second-elements [collection]
  (let [second (fn [v] (get v 1))]
     (map second collection)))

(defn titles [books]
  (map :title books))

(defn monotonic? [a-seq]
  (or (apply <= a-seq) (apply >= a-seq)))

(defn stars [n]
  (apply str (repeat n "*")))

(defn toggle [a-set elem]
  (cond 
   (contains? a-set elem) (disj a-set elem)
   :else (conj a-set elem)))

(defn contains-duplicates? [a-seq]
  (not (= (count a-seq) (count (set a-seq)))))

(defn old-book->new-book [book]
  (assoc book :authors (set (:authors book))))

(defn has-author? [book author]
 (contains? (:authors book) author))

(defn authors [books]
  (apply clojure.set/union (map :authors books)))

(defn all-author-names [books]
  (set (map :name (authors books))))

(defn author->string [author]
(let [name (:name author)
      year (fn [auth]
   (cond 
   (contains? auth :death-year) (str " (" (:birth-year author) " - " (:death-year author) ")")
   (contains? auth :birth-year) (str " (" (:birth-year author) " - )")
   :else                        ""))]
   (str name (year author))))

(defn authors->string [authors]
  (apply str (interpose ", " (map author->string authors))))

(defn book->string [book]
  (str (:title book) ", written by " (authors->string (:authors book))))

(defn books->string [books]
  (cond
  (empty? books) "No books."
  (= (count books) 1) (str "1 book. " (book->string (get books 0)) ".")
  :else (str (count books) " books. " (apply str (interpose ". " (map book->string books))) ".")))

(defn books-by-author [author books]
  (filter (fn [book] (has-author? book author)) books))

(defn author-by-name [name authors]
(let [result (filter (fn [author] (= (:name author) name)) authors)]
   (cond
   (empty? result) nil
   :else (first result))))

(defn living-authors [authors]
 (filter (fn [author] (alive? author)) authors))

(defn has-a-living-author? [book]
(> (count (filter (fn [author] (alive? author)) (:authors book))) 0))

(defn books-by-living-authors [books]
 (filter (fn [book] (has-a-living-author? book)) books))

; %________%
