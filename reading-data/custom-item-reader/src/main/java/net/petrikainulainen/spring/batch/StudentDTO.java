package net.petrikainulainen.spring.batch;

/**
 * Contains the information that's returned by our custom
 * ItemReader.
 */
public class StudentDTO {

    private String emailAddress;
    private String name;
    private String purchasedPackage;
    private Integer age;

    public StudentDTO() {}

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPurchasedPackage() {
        return purchasedPackage;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer name) {
        this.age = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setPurchasedPackage(String purchasedPackage) {
        this.purchasedPackage = purchasedPackage;
    }

	public static StudentBuilder builder() {
		return new StudentBuilder();
	}

	public static class StudentBuilder {
		private StudentDTO emp;

		public StudentBuilder() {
			emp = new StudentDTO();
		}

		public StudentBuilder name(String name) {
			emp.setName(name);
			return this;
		}

		public StudentBuilder age(Integer name) {
			emp.setAge(name);
			return this;
		}

		public StudentBuilder emailAddress(String mail) {
			emp.setEmailAddress(mail);
			return this;
		}

		public StudentBuilder purchasedPackage(String pack) {
			emp.setPurchasedPackage(pack);
			return this;
		}

		public StudentDTO build() {
			return emp;
		}
	}




    @Override
    public String toString() {
        return "[name=" + name + ",\tage=" + age + "]";
    }
}
