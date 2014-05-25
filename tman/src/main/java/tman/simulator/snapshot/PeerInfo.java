package tman.simulator.snapshot;

import cyclon.system.peer.cyclon.PeerDescriptor;
import java.util.ArrayList;
import se.sics.kompics.address.Address;


public class PeerInfo {
	private ArrayList<PeerDescriptor> tmanPartners;
	private ArrayList<Address> cyclonPartners;


	public PeerInfo() {
		this.tmanPartners = new ArrayList<PeerDescriptor>();
		this.cyclonPartners = new ArrayList<Address>();
	}


	public void updateTManPartners(ArrayList<PeerDescriptor> partners) {
		this.tmanPartners = partners;
	}


	public void updateCyclonPartners(ArrayList<Address> partners) {
		this.cyclonPartners = partners;
	}


	public ArrayList<PeerDescriptor> getTManPartners() {
		return this.tmanPartners;
	}


	public ArrayList<Address> getCyclonPartners() {
		return this.cyclonPartners;
	}
}
