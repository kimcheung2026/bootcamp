package com.bootcamp.demo;

public interface MathOperationGen<T extends Number, //
    U extends Number, R extends Number> {
  R compute(T t, U u);

}
