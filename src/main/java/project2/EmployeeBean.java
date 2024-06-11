package project2;

import java.io.Serializable;

@SuppressWarnings("serial")
public class EmployeeBean implements Serializable{
private int employee_ID;
private String PassWord;
private String First_Name;
private String Middle_Name;
private String Last_Name;
private String Father_Name;
private String Mother_Name;
private String Phone;
private String Email;
private String City;
private String Address;
private String Postal_Code ;
private String  Qualification;
private String  UserType;
private String  Gender;
private String  Marital_Status;
private String  Department;
public EmployeeBean() {
	super();
}
public int getEmployee_ID() {
	return employee_ID;
}
public void setEmployee_ID(int employee_ID) {
	this.employee_ID = employee_ID;
}
public String getPassWord() {
	return PassWord;
}
public void setPassWord(String passWord) {
	PassWord = passWord;
}
public String getFirst_Name() {
	return First_Name;
}
public void setFirst_Name(String first_Name) {
	First_Name = first_Name;
}
public String getMiddle_Name() {
	return Middle_Name;
}
public void setMiddle_Name(String middle_Name) {
	Middle_Name = middle_Name;
}
public String getLast_Name() {
	return Last_Name;
}
public void setLast_Name(String last_Name) {
	Last_Name = last_Name;
}
public String getFather_Name() {
	return Father_Name;
}
public void setFather_Name(String father_Name) {
	Father_Name = father_Name;
}
public String getMother_Name() {
	return Mother_Name;
}
public void setMother_Name(String mother_Name) {
	Mother_Name = mother_Name;
}
public String getPhone() {
	return Phone;
}
public void setPhone(String phone) {
	Phone = phone;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
public String getCity() {
	return City;
}
public void setCity(String city) {
	City = city;
}
public String getAddress() {
	return Address;
}
public void setAddress(String address) {
	Address = address;
}
public String getPostal_Code() {
	return Postal_Code;
}
public void setPostal_Code(String postal_Code) {
	Postal_Code = postal_Code;
}
public String getQualification() {
	return Qualification;
}
public void setQualification(String qualification) {
	Qualification = qualification;
}
public String getUserType() {
	return UserType;
}
public void setUserType(String userType) {
	UserType = userType;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getMarital_Status() {
	return Marital_Status;
}
public void setMarital_Status(String marital_Status) {
	Marital_Status = marital_Status;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
@Override
public String toString() {
	return "EmployeeBean [employee_ID=" + employee_ID + ", PassWord=" + PassWord + ", First_Name=" + First_Name
			+ ", Middle_Name=" + Middle_Name + ", Last_Name=" + Last_Name + ", Father_Name=" + Father_Name
			+ ", Mother_Name=" + Mother_Name + ", Phone=" + Phone + ", Email=" + Email + ", City=" + City + ", Address="
			+ Address + ", Postal_Code=" + Postal_Code + ", Qualification=" + Qualification + ", UserType=" + UserType
			+ ", Gender=" + Gender + ", Marital_Status=" + Marital_Status + ", Department=" + Department + "]";
}

}
