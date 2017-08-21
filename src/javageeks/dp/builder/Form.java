/**
 * 
 */
package javageeks.dp.builder;

import java.util.Date;

/**
 * @author Rishabh.Daim
 *
 */
public class Form {
	private final String firstName;
	private final String lastName;
	private final String userName;
	private final String password;
	private final String address;
	private final Date dob;
	private final String email;
	private final String backupEmail;
	private final String spouseName;
	private final String city;
	private final String state;
	private final String country;
	private final String language;
	private final String passwordHint;
	private final String securityQuestion;
	private final String securityAnswer;

	/**
	 * @param firstName
	 * @param lastName
	 * @param userName
	 * @param password
	 * @param address
	 * @param dob
	 * @param email
	 * @param backupEmail
	 * @param spouseName
	 * @param city
	 * @param state
	 * @param country
	 * @param language
	 * @param passwordHint
	 * @param securityQuestion
	 * @param securityAnswer
	 */
	private Form(final FormBuilder formBuilder) {
		this.firstName = formBuilder.firstName;
		this.lastName = formBuilder.lastName;
		this.userName = formBuilder.userName;
		this.password = formBuilder.password;
		this.address = formBuilder.address;
		this.dob = formBuilder.dob;
		this.email = formBuilder.email;
		this.backupEmail = formBuilder.backupEmail;
		this.spouseName = formBuilder.spouseName;
		this.city = formBuilder.city;
		this.state = formBuilder.state;
		this.country = formBuilder.country;
		this.language = formBuilder.language;
		this.passwordHint = formBuilder.passwordHint;
		this.securityQuestion = formBuilder.securityQuestion;
		this.securityAnswer = formBuilder.securityAnswer;
	}

	public static class FormBuilder {
		private final String firstName;
		private final String lastName;
		private final String userName;
		private final String password;
		private String address;
		private Date dob;
		private String email;
		private String backupEmail;
		private String spouseName;
		private String city;
		private String state;
		private String country;
		private String language;
		private String passwordHint;
		private String securityQuestion;
		private String securityAnswer;

		/**
		 * @param firstName
		 * @param lastName
		 * @param userName
		 * @param password
		 */
		public FormBuilder(String firstName, String lastName, String userName,
				String password) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.userName = userName;
			this.password = password;
		}

		public FormBuilder address(String address) {
			this.address = address;
			return this;
		}

		public FormBuilder dob(Date dob) {
			this.dob = new Date(dob.getTime());
			return this;
		}

		public FormBuilder email(String email) {
			this.email = email;
			return this;
		}

		public FormBuilder backupEmail(String backupEmail) {
			this.backupEmail = backupEmail;
			return this;
		}

		public FormBuilder spouseName(String spouseName) {
			this.spouseName = spouseName;
			return this;
		}

		public FormBuilder city(String city) {
			this.city = city;
			return this;
		}

		public FormBuilder state(String state) {
			this.state = state;
			return this;
		}

		public FormBuilder country(String country) {
			this.country = country;
			return this;
		}

		public FormBuilder language(String language) {
			this.language = language;
			return this;
		}

		public FormBuilder passwordHint(String passwordHint) {
			this.passwordHint = passwordHint;
			return this;
		}

		public FormBuilder securityQuestion(String securityQuestion) {
			this.securityQuestion = securityQuestion;
			return this;
		}

		public FormBuilder securityAnswer(String securityAnswer) {
			this.securityAnswer = securityAnswer;
			return this;
		}

		public Form build() {
			return new Form(this);
		}
	}

	/**
	 * @return the firstName
	 */
	public final String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return lastName;
	}

	/**
	 * @return the userName
	 */
	public final String getUserName() {
		return userName;
	}

	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}

	/**
	 * @return the address
	 */
	public final String getAddress() {
		return address;
	}

	/**
	 * @return the dob
	 */
	public final Date getDob() {
		return new Date(dob.getTime());
	}

	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}

	/**
	 * @return the backupEmail
	 */
	public final String getBackupEmail() {
		return backupEmail;
	}

	/**
	 * @return the spouseName
	 */
	public final String getSpouseName() {
		return spouseName;
	}

	/**
	 * @return the city
	 */
	public final String getCity() {
		return city;
	}

	/**
	 * @return the state
	 */
	public final String getState() {
		return state;
	}

	/**
	 * @return the country
	 */
	public final String getCountry() {
		return country;
	}

	/**
	 * @return the language
	 */
	public final String getLanguage() {
		return language;
	}

	/**
	 * @return the passwordHint
	 */
	public final String getPasswordHint() {
		return passwordHint;
	}

	/**
	 * @return the securityQuestion
	 */
	public final String getSecurityQuestion() {
		return securityQuestion;
	}

	/**
	 * @return the securityAnswer
	 */
	public final String getSecurityAnswer() {
		return securityAnswer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Form [");
		if (firstName != null) {
			builder.append("firstName=");
			builder.append(firstName);
			builder.append(", ");
		}
		if (lastName != null) {
			builder.append("lastName=");
			builder.append(lastName);
			builder.append(", ");
		}
		if (userName != null) {
			builder.append("userName=");
			builder.append(userName);
			builder.append(", ");
		}
		if (password != null) {
			builder.append("password=");
			builder.append(password);
			builder.append(", ");
		}
		if (address != null) {
			builder.append("address=");
			builder.append(address);
			builder.append(", ");
		}
		if (dob != null) {
			builder.append("dob=");
			builder.append(dob);
			builder.append(", ");
		}
		if (email != null) {
			builder.append("email=");
			builder.append(email);
			builder.append(", ");
		}
		if (backupEmail != null) {
			builder.append("backupEmail=");
			builder.append(backupEmail);
			builder.append(", ");
		}
		if (spouseName != null) {
			builder.append("spouseName=");
			builder.append(spouseName);
			builder.append(", ");
		}
		if (city != null) {
			builder.append("city=");
			builder.append(city);
			builder.append(", ");
		}
		if (state != null) {
			builder.append("state=");
			builder.append(state);
			builder.append(", ");
		}
		if (country != null) {
			builder.append("country=");
			builder.append(country);
			builder.append(", ");
		}
		if (language != null) {
			builder.append("language=");
			builder.append(language);
			builder.append(", ");
		}
		if (passwordHint != null) {
			builder.append("passwordHint=");
			builder.append(passwordHint);
			builder.append(", ");
		}
		if (securityQuestion != null) {
			builder.append("securityQuestion=");
			builder.append(securityQuestion);
			builder.append(", ");
		}
		if (securityAnswer != null) {
			builder.append("securityAnswer=");
			builder.append(securityAnswer);
		}
		builder.append("]");
		return builder.toString();
	}

}
