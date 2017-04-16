# Functional Programming in Scala
My personal notes, code examples and tutorials on functional programming in Scala, based on the book "Functional Programming in Scala by Paul Chiusano and Rúnar Bjarnason" 

##Referential Transparency
If all occurances of an expressions can be replaced in a program can be replaced with the expression's evaluated value, without any change to the outcome of the program, then the expression is said to be "referentially transparent".
##Pure Function
A function is said to be pure if the expression of that function is referentially transparent for all referentially transparent inouts.

In Scala a (pure) function with input type A and output Type B (type: A => B), computes exactly one value of b of type B for a given value a of Type A.

In layman's terms a pure function is a function with no side effects.


## Libraries used:
1. Scala 2.12.1

## How to Run:
Just open a Scala REPEL and type away... mostly.