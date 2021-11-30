(ns hospital-test-clojure.logic-test
  (:require [clojure.test :refer :all]
            [hospital-test-clojure.logic :refer :all]))

;boundary tests
;exatamente na borda e one off. -1, +1, <=, >=, =
;checklist para tests

(deftest cabe-na-fila?-test

  ;borda do zero
  (testing "Que cabe na fila"
    (is (cabe-na-fila? {:espera []}, :espera)))

  ;borda do limite
  (testing "Que não cabe na fila quando a fila está cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5]}, :espera))))

  ;one off da borda do limite para cima
  (testing "Que não cabe na fila quando tem mais do que uma fila cheia"
    (is (not (cabe-na-fila? {:espera [1 2 3 4 5 6]}, :espera))))

  ;dentro das bordas
  (testing "Que cabe na fila quando tem pouco menos do que uma fila cheia"
    (is (cabe-na-fila? {:espera [1 2 3 4]}, :espera))
    (is (cabe-na-fila? {:espera [1 2]}, :espera)))

  (testing "Que não cabe quando o departamento não existe"
    (is (not (cabe-na-fila? {:espera [1 2 3 4]}, :raio-x)))))


(deftest chega-em-test

  (testing "aceita pessoas enquanto cabem pessoas na fila"
    (is (= {:espera [1, 2, 3, 4, 5]}
           (chega-em {:espera [1, 2, 3, 4]}, :espera, 5)))

    (is (= {:espera [1, 2, 5]}
           (chega-em {:espera [1, 2]}, :espera, 5))))

  (testing "não aceita quando não cabe na fila"
    ;(is (thrown? clojure.lang.ExceptionInfo "não cabe ninguém neste departamento."
    ;(chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)))

    ;(is (thrown? IllegalStateException
    ;(chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)))

    (is (nil? (chega-em {:espera [1, 35, 42, 64, 21]}, :espera 76)))))





























