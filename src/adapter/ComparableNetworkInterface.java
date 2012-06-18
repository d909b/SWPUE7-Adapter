package adapter;

import java.net.NetworkInterface;

/**
 * The ComparableNetworkInterface class is an object-based adapter class to make java's NetworkInterface conform to the 
 * Comparable interface.
 * 
 * @author patrick
 */
public class ComparableNetworkInterface implements Comparable<ComparableNetworkInterface> {
	NetworkInterface adaptee;
	
	/**
	 * Constructs a ComparableNetworkInterface from an underlying NetworkInterface.
	 * 
	 * @param networkInterface The underlying NetworkInterface
	 */
	public ComparableNetworkInterface(NetworkInterface networkInterface) {
		adaptee = networkInterface;
	}

	/**
	 * Compares this ComparableNetworkInterface to another ComparableNetworkInterface by their respective names.
	 * 
	 * @returns The comparison result based on a comparison of their respective names.
	 */
	@Override
	public int compareTo(ComparableNetworkInterface other) {
		return other.getName().compareTo( getName() );
	}
	
	/**
	 * Getter for the network interfaces' name.
	 * 
	 * @return The network interfaces' name.
	 */
	public String getName() {
		return adaptee.getName();
	}
}
