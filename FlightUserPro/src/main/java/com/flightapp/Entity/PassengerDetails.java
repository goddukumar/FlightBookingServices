package com.flightapp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="passnger_details")
public class PassengerDetails {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int  passangerId;
	    private String passengerName;
	    private int age;
	    private String gender;
	    
		
		public int getPassangerId() {
			return passangerId;
		}
		public void setPassangerId(int passangerId) {
			this.passangerId = passangerId;
		}
		public String getPassengerName() {
			return passengerName;
		}
		public void setPassengerName(String passengerName) {
			this.passengerName = passengerName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
}
