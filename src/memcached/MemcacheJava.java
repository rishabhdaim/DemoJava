/**
 * 
 */
package memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.internal.OperationFuture;

/**
 * @author Rishabh.Daim
 *
 */
public class MemcacheJava {
	
	private static final String DUMMY_VALUE = "dummyValue";
	private static final String NEW_VALUE = "newValue";
	private static final String CAS_VALUE = "casValue";
	private static final String NUMBER_VALUE = "100";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		MemcachedClient mcc = null;
		
		try {
			// Connecting to Memcached server on localhost
			final int portNumber = 11211;
			mcc = new MemcachedClient(new InetSocketAddress("IONDELWS398", portNumber));
			 System.out.println("Connection to server sucessful.");
			 
			 // set data into memcache server
			 OperationFuture<Boolean> future = mcc.set(DUMMY_VALUE, 90, DUMMY_VALUE);
			 
			// print status of set method
	         System.out.println("set status:" + future.get());
	         
	         // retrieve and check the value from cache
	         System.out.println("Value in cache - " + mcc.get(DUMMY_VALUE));
	         
	         // add data with exiting key
	         OperationFuture<Boolean> add = mcc.add(DUMMY_VALUE, 30, DUMMY_VALUE);
	         System.out.println("Adding exiting key : " + add.get());
	         
	         // add data with new key
	         add = mcc.add(NEW_VALUE, 30, NEW_VALUE);
	         System.out.println("Adding new key : " + add.getKey() + " result is : " + add.get());
	         
	         // replace exiting key data
	         OperationFuture<Boolean> replace = mcc.replace(DUMMY_VALUE, 900, NEW_VALUE);
	         System.out.println("replace key : " + replace.getKey() + " result : " + replace.get() + " new value : " + mcc.get(DUMMY_VALUE));
	         
	         // replace exiting key data
	         OperationFuture<Boolean> append = mcc.append(NEW_VALUE, DUMMY_VALUE);
	         System.out.println("Append key : " + append.getKey() + " result : " + append.get() + " new value : " + mcc.get(NEW_VALUE));
	         
	         // replace exiting key data
	         OperationFuture<Boolean> prepend = mcc.prepend(NEW_VALUE, DUMMY_VALUE);
	         System.out.println("Prepend key : " + prepend.getKey() + " result : " + prepend.get() + " new value : " + mcc.get(NEW_VALUE));
	         
	         // Cas Operation
	         OperationFuture<Boolean> set = mcc.set(CAS_VALUE, 900, CAS_VALUE);
	         System.out.println("Set key : " + set.getKey() + " : value : " + mcc.get(CAS_VALUE));
	         
	         CASValue<Object> casValue = mcc.gets(CAS_VALUE);
	         System.out.println("Cas Token : " + casValue);
	         
	         CASResponse casResponse = mcc.cas(CAS_VALUE, casValue.getCas(), DUMMY_VALUE);
	         System.out.println("Cas Response : " + casResponse);
	         System.out.println("Key : " + CAS_VALUE + " has value : " + mcc.get(CAS_VALUE));
	         
	         // delete already exiting key
	         OperationFuture<Boolean> delete = mcc.delete(CAS_VALUE);
	         System.out.println("deleting key : " + delete.getKey() + " result : " + delete.get());
	         
	         // ince/decre value
	         OperationFuture<Boolean> number = mcc.set(NUMBER_VALUE, 900, NUMBER_VALUE);
	         System.out.println("Adding key : " + number.getKey() + " result : " + number.get() + " value is : " + mcc.get(NUMBER_VALUE));
	         System.out.println("Increment Key : " + number.getKey() + " value after inrement is : " + mcc.incr(NUMBER_VALUE, 120));
	         System.out.println("Decrement Key : " + number.getKey() + " value after derement is : " + mcc.decr(NUMBER_VALUE, 120));
	         
	         // get stats
	         System.out.println("MemCache stats : " + mcc.getStats());
			 
		} catch (IOException | InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			// Shutdowns the memcached client
			if (mcc != null) {
				System.out.println("Shutting Memcached server.");
				mcc.shutdown();
			}
		}
	}

}
