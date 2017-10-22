(ns structured-data)

(defn do-a-thing [x]
 (let [x (+ x x)]
   x))

(defn spiff [v]
 (+ (get v 0) (get v 2))) //get a NullPointerException when passing a vector too short

(defn cutify [v]
 ( conj v "<3"))

(defn spiff-destructuring [v]
 (+ (first v)(nth v 2))) 

(defn point [x y]
  [x y])

(defn rectangle [bottom-left top-right]
  [bottom-left top-right])

(defn width [rectangle]
  (-(first rectangle)(first rectangle)))  //do this one

(defn height [rectangle]
  :-) //do this one

(defn square? [rectangle]
  :-) //do this one

(defn area [rectangle]
  :-) //do this one

(defn contains-point? [rectangle point]
  :-) //do this one

(defn contains-rectangle? [outer inner]
  :-) //do this one

(defn title-length [book]
  (count (:title book))) //it counts spaces as well

(defn author-count [book]
  (count (:authors book)))

(defn multiple-authors? [book]
 (cond
   (> (count (:authors book)) 1)
      true
      :else false))

(defn add-author [book new-author]
:-)

(defn alive? [author]
 (cond
   (contains? author :death-year) false
   :else true))

(defn element-lengths [collection]
  :-)

(defn second-elements [collection]
  :-)

(defn titles [books]
  :-)

(defn monotonic? [a-seq]
  :-)

(defn stars [n]
  :-)

(defn toggle [a-set elem]
  :-)

(defn contains-duplicates? [a-seq]
  :-)

(defn old-book->new-book [book]
  :-)

(defn has-author? [book author]
  :-)

(defn authors [books]
  :-)

(defn all-author-names [books]
  :-)

(defn author->string [author]
:-)

(defn authors->string [authors]
  :-)

(defn book->string [book]
  :-)

(defn books->string [books]
  :-)

(defn books-by-author [author books]
  :-)

(defn author-by-name [name authors]
  :-)

(defn living-authors [authors]
  :-)

(defn has-a-living-author? [book]
  :-)

(defn books-by-living-authors [books]
  :-)

; %________%
