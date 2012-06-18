package adapter;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

public class NetworkInterfaceSorter {
	/**
	 * This application sorts NetworkInterface's by their name.
	 * As NetworkInterfaces don't implement the Comparable Interface, an adapter class ComparableNetworkInterface
	 * is used to make sorting possible. 
	 * 
	 * @param args Command line parameters.
	 */
	public static void main(String[] args) {
		
		Enumeration<NetworkInterface> enumeration = null;
		try {
			enumeration = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			System.err.println("Could not retrieve the list of available network interfaces.");
			System.exit(1);
		}
		
		ArrayList<ComparableNetworkInterface> comparableNetworkInterfaces = new ArrayList<ComparableNetworkInterface>();
		while (enumeration.hasMoreElements()) {
			NetworkInterface networkInterface = enumeration.nextElement();
			
			ComparableNetworkInterface comparableNetworkInterface = new ComparableNetworkInterface(networkInterface);
			
			comparableNetworkInterfaces.add(comparableNetworkInterface);
		}
		
		Collections.sort(comparableNetworkInterfaces);
		
		int i = 1;
		for(ComparableNetworkInterface cni : comparableNetworkInterfaces) {
			System.out.println("[" + i++ + "]: " + cni.getName());
		}
	}

}
