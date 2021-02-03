package com.mobiquity.assignment.atmlocator.beans;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** 
 * 
 * @author cnu4u
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtmDetails {

	public AtmDetails() {
		// TODO Auto-generated constructor stub
	}
	
	/*public AtmDetails(Address address) {
		
        this.address.street = address.getStreet();
        this.address.housenumber = address.getStreet();
        this.address.postalcode = address.getStreet();
        this.address.city = address.getCity();
        this.address.geoLocation = address.getGeoLocation();
       
    }*/
	

	private Address address;

	

	public Address getAddress() {
		return address;
	}



	public void setAddress(Address address) {
		this.address = address;
	}



	@JsonIgnoreProperties(ignoreUnknown = true)
	public class Address {
		private String street;
		private String housenumber;
		private String postalcode;
		private String city;
		

		public Address() {
			// TODO Auto-generated constructor stub
		}

		private GeoLocation geoLocation;

		public GeoLocation getGeoLocation() {
			return geoLocation;
		}

		public void setGeoLocation(GeoLocation geoLocation) {
			this.geoLocation = geoLocation;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String street) {
			this.street = street;
		}

		public String getHousenumber() {
			return housenumber;
		}

		public void setHousenumber(String housenumber) {
			this.housenumber = housenumber;
		}

		public String getPostalcode() {
			return postalcode;
		}

		public void setPostalcode(String postalcode) {
			this.postalcode = postalcode;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
		
		@JsonIgnoreProperties(ignoreUnknown = true)
		private class GeoLocation {
			private double lat;
			private double lng;

			public double getLat() {
				return lat;
			}

			public void setLat(double lat) {
				this.lat = lat;
			}

			public double getLng() {
				return lng;
			}

			public void setLng(double lng) {
				this.lng = lng;
			}

			public GeoLocation() {
				// TODO Auto-generated constructor stub
			}
		}
	}
	
}
