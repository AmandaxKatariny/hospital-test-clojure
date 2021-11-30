(ns hospital-test-clojure.logic)

; Test Driven Development
; Test Driven Design

; -- existe um problema de condicional quando o departamento não existe --
; (defn cabe-na-fila?
;  "verifica se cabe mais alguem na fila de espera"
;  [hospital departamento]
;  ;(count (get hospital departamento))
;(-> hospital
;    departamento
;    count
;    (< 5)))

; -- Funciona para o caso de não ter o departament--
;(defn cabe-na-fila?
;  [hospital departamento]
;(when-let [fila (get hospital departamento)]
;(-> fila
;    count
;    (< 5)) ) )

; -- tambem funciona mas usa o some
; desvantagem/vantagem "menos explicito"
; desvantagem qualquer um quer der niel, devolve nil
(defn cabe-na-fila?
  [hospital departamento]
  (some-> hospital
          departamento
          count
          (< 5)))