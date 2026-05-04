package com.bootcamp.demo;

@FunctionalInterface // ! One method only
public interface MathOperation<T extends Number, U extends Number, R extends Number> {
  R compute(T t, U u);
}