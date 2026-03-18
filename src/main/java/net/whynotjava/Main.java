package net.whynotjava;

import java.util.*;

import javax.bluetooth.*;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

public class Main{
    public static void main(String[] args) {
        System.out.println("===== START =====");
        // System.out.println("DiscoveryAgent CACHED - "+DiscoveryAgent.CACHED);

        System.out.println("[S]erver or [C]lient? ");
        Scanner scan = new Scanner(System.in);

        boolean server = scan.next().equals("s");

        System.out.println("You are now the "+ (server?"SERVER":"CLIENT"));

        try {

        LocalDevice ld = LocalDevice.getLocalDevice();

        System.out.println("is power on? " + LocalDevice.isPowerOn());
        System.out.println("ld bluetooth address: "+ld.getBluetoothAddress());
        System.out.println("ld friendly name: "+ld.getFriendlyName());

        DiscoveryAgent da = ld.getDiscoveryAgent();

        // RemoteDevice rd[] = da.retrieveDevices(DiscoveryAgent.PREKNOWN);

        // System.out.println("retrived devices!");
        // for(RemoteDevice device : rd){
        //     // System.out.println("friendly name: "+device.getFriendlyName(true));
        //     System.out.println("address      : "+device.getBluetoothAddress()+" is trusted: "+device.isTrustedDevice());
        // }

        // ServiceRecord sr = ld.

        boolean isDiscoverable = ld.setDiscoverable(DiscoveryAgent.GIAC);
         System.out.println("Am I discoverable? " + isDiscoverable);
        System.out.println("My Bluetooth Name: " + ld.getFriendlyName());  

        String serviceName = "JavaTestService";
        String serviceUUIDString = "1234";
        UUID serviceUUID = new UUID(serviceUUIDString, true);

        String connURL = ("btspp://localhost:"+serviceUUID.toString()+";name="+serviceName);

        StreamConnectionNotifier scn = (StreamConnectionNotifier) Connector.open(connURL);
        ServiceRecord record = LocalDevice.getLocalDevice().getRecord(scn);
        System.out.println("Service is live on channel: " + record.getConnectionURL(0, false));
        System.out.println("accept and open!");
        StreamConnection sc = scn.acceptAndOpen();
        System.out.println("OPENED!");


        

        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("===== END/EXIT =====");
    }
}