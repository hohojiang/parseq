package com.linkedin.parseq.promise;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class TestSettablePromise extends AbstractSettablePromiseTest
{
  @Test
  public void testPromiseInitialState()
  {
    assertFalse(Promises.settable().isDone());
    assertFalse(Promises.settable().isFailed());
  }

  @Override
  protected <T> Promise<T> createPromise()
  {
    return Promises.settable();
  }

  @Override
  protected <T> void setPromiseValue(Promise<T> promise, T value)
  {
    ((SettablePromise<T>)promise).done(value);
  }

  @Override
  protected <T> void setPromiseError(Promise<T> promise, Throwable error)
  {
    ((SettablePromise<T>)promise).fail(error);
  }
}
