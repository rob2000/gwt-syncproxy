package com.gdevelop.gwt.syncrpc.test.poj;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.TestCase;

import com.gdevelop.gwt.syncrpc.SyncProxy;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ValueTypesTestServiceAsync;

/**
 * Base on com.google.gwt.user.client.rpc.*Test
 */
public class ValueTypesTest extends TestCase {
	private static ValueTypesTestServiceAsync service = (ValueTypesTestServiceAsync) SyncProxy
			.newProxyInstance(ValueTypesTestServiceAsync.class,
					"http://127.0.0.1:8888/spawebtest/", "valuetypes", true);

	public ValueTypesTest() {
	}

	public void testBoolean_FALSE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);

		service.echo_FALSE(false, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Boolean result) {
				assertNotNull(result);
				assertFalse(result.booleanValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testBoolean_TRUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_TRUE(true, new AsyncCallback<Boolean>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Boolean result) {
				assertNotNull(result);
				assertTrue(result.booleanValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testByte() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo((byte) (Byte.MAX_VALUE / (byte) 2),
				new AsyncCallback<Byte>() {

					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Byte result) {
						assertNotNull(result);
						assertEquals(Byte.MAX_VALUE / 2, result.byteValue());
						signal.countDown();
					}

				});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testByte_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MAX_VALUE(Byte.MAX_VALUE, new AsyncCallback<Byte>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Byte result) {
				assertNotNull(result);
				assertEquals(Byte.MAX_VALUE, result.byteValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testByte_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MIN_VALUE(Byte.MIN_VALUE, new AsyncCallback<Byte>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Byte result) {
				assertNotNull(result);
				assertEquals(Byte.MIN_VALUE, result.byteValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testChar() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo((char) (Character.MAX_VALUE / (char) 2),
				new AsyncCallback<Character>() {

					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Character result) {
						assertNotNull(result);
						assertEquals(Character.MAX_VALUE / 2,
								result.charValue());
						signal.countDown();
					}

				});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testChar_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MAX_VALUE(Character.MAX_VALUE,
				new AsyncCallback<Character>() {

					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Character result) {
						assertNotNull(result);
						assertEquals(Character.MAX_VALUE, result.charValue());
						signal.countDown();
					}

				});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testChar_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MIN_VALUE(Character.MIN_VALUE,
				new AsyncCallback<Character>() {

					@Override
					public void onFailure(Throwable caught) {
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Character result) {
						assertNotNull(result);
						assertEquals(Character.MIN_VALUE, result.charValue());
						signal.countDown();
					}

				});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testDouble() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Double.MAX_VALUE / 2, new AsyncCallback<Double>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Double result) {
				assertNotNull(result);
				assertEquals(Double.MAX_VALUE / 2, result.doubleValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testDouble_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MAX_VALUE(Double.MAX_VALUE, new AsyncCallback<Double>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Double result) {
				assertNotNull(result);
				assertEquals(Double.MAX_VALUE, result.doubleValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testDouble_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MIN_VALUE(Double.MIN_VALUE, new AsyncCallback<Double>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Double result) {
				assertNotNull(result);
				assertEquals(Double.MIN_VALUE, result.doubleValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	/**
	 * Validate that NaNs (not-a-number, such as 0/0) propagate properly via
	 * RPC.
	 * 
	 * @throws InterruptedException
	 */
	public void testDouble_NaN() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Double.NaN, new AsyncCallback<Double>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Double result) {
				assertNotNull(result);
				assertTrue(Double.isNaN(result.doubleValue()));
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	/**
	 * Validate that negative infinity propagates properly via RPC.
	 * 
	 * @throws InterruptedException
	 */
	public void testDouble_NegInfinity() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Double.NEGATIVE_INFINITY, new AsyncCallback<Double>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Double result) {
				assertNotNull(result);
				double doubleValue = result.doubleValue();
				assertTrue(Double.isInfinite(doubleValue) && doubleValue < 0);
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	/**
	 * Validate that positive infinity propagates properly via RPC.
	 * 
	 * @throws InterruptedException
	 */
	public void testDouble_PosInfinity() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Double.POSITIVE_INFINITY, new AsyncCallback<Double>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Double result) {
				assertNotNull(result);
				double doubleValue = result.doubleValue();
				assertTrue(Double.isInfinite(doubleValue) && doubleValue > 0);
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testFloat() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Float.MAX_VALUE / 2, new AsyncCallback<Float>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Float result) {
				assertNotNull(result);
				assertEquals(Float.MAX_VALUE / 2, result.floatValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testFloat_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MAX_VALUE(Float.MAX_VALUE, new AsyncCallback<Float>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Float result) {
				assertNotNull(result);
				assertEquals(Float.MAX_VALUE, result.floatValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testFloat_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MIN_VALUE(Float.MIN_VALUE, new AsyncCallback<Float>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Float result) {
				assertNotNull(result);
				assertEquals(Float.MIN_VALUE, result.floatValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	/**
	 * Validate that NaNs (not-a-number, such as 0/0) propagate properly via
	 * RPC.
	 * 
	 * @throws InterruptedException
	 */
	public void testFloat_NaN() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Float.NaN, new AsyncCallback<Float>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Float result) {
				assertNotNull(result);
				assertTrue(Float.isNaN(result.floatValue()));
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	/**
	 * Validate that negative infinity propagates properly via RPC.
	 * 
	 * @throws InterruptedException
	 */
	public void testFloat_NegInfinity() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Float.NEGATIVE_INFINITY, new AsyncCallback<Float>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Float result) {
				assertNotNull(result);
				float floatValue = result.floatValue();
				assertTrue(Float.isInfinite(floatValue) && floatValue < 0);
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	/**
	 * Validate that positive infinity propagates properly via RPC.
	 * 
	 * @throws InterruptedException
	 */
	public void testFloat_PosInfinity() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Float.POSITIVE_INFINITY, new AsyncCallback<Float>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Float result) {
				assertNotNull(result);
				float floatValue = result.floatValue();
				assertTrue(Float.isInfinite(floatValue) && floatValue > 0);
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testInteger() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Integer.MAX_VALUE / 2, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Integer result) {
				assertNotNull(result);
				assertEquals(Integer.MAX_VALUE / 2, result.intValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testInteger_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Integer.MAX_VALUE, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Integer result) {
				assertNotNull(result);
				assertEquals(Integer.MAX_VALUE, result.intValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testInteger_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Integer.MIN_VALUE, new AsyncCallback<Integer>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Integer result) {
				assertNotNull(result);
				assertEquals(Integer.MIN_VALUE, result.intValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testLong() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo(Long.MAX_VALUE / 2, new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Long result) {
				assertNotNull(result);
				assertEquals(Long.MAX_VALUE / 2, result.longValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testLong_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MAX_VALUE(Long.MAX_VALUE, new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Long result) {
				assertNotNull(result);
				assertEquals(Long.MAX_VALUE, result.longValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testLong_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MIN_VALUE(Long.MIN_VALUE, new AsyncCallback<Long>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Long result) {
				assertNotNull(result);
				assertEquals(Long.MIN_VALUE, result.longValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testShort() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo((short) (Short.MAX_VALUE / 2), new AsyncCallback<Short>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Short result) {
				assertNotNull(result);
				assertEquals(Short.MAX_VALUE / 2, result.shortValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testShort_MAX_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MAX_VALUE(Short.MAX_VALUE, new AsyncCallback<Short>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Short result) {
				assertNotNull(result);
				assertEquals(Short.MAX_VALUE, result.shortValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}

	public void testShort_MIN_VALUE() throws InterruptedException {
		final CountDownLatch signal = new CountDownLatch(1);
		service.echo_MIN_VALUE(Short.MIN_VALUE, new AsyncCallback<Short>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}

			@Override
			public void onSuccess(Short result) {
				assertNotNull(result);
				assertEquals(Short.MIN_VALUE, result.shortValue());
				signal.countDown();
			}

		});
		assertTrue("Failed to Complete", signal.await(2, TimeUnit.SECONDS));
	}
}
