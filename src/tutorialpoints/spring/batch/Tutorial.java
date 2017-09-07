/**
 * 
 */
package tutorialpoints.spring.batch;

/**
 * @author Rishabh.Daim
 *
 */
public class Tutorial {

	private int tutorial_id;
	private String tutorial_author;
	private String tutorial_title;
	private String submission_date;
	private String tutorial_icon;
	private String tutorial_description;
	/**
	 * @return the tutorial_id
	 */
	public final int getTutorial_id() {
		return tutorial_id;
	}
	/**
	 * @param tutorial_id the tutorial_id to set
	 */
	public final void setTutorial_id(int tutorial_id) {
		this.tutorial_id = tutorial_id;
	}
	/**
	 * @return the tutorial_author
	 */
	public final String getTutorial_author() {
		return tutorial_author;
	}
	/**
	 * @param tutorial_author the tutorial_author to set
	 */
	public final void setTutorial_author(String tutorial_author) {
		this.tutorial_author = tutorial_author;
	}
	/**
	 * @return the tutorial_title
	 */
	public final String getTutorial_title() {
		return tutorial_title;
	}
	/**
	 * @param tutorial_title the tutorial_title to set
	 */
	public final void setTutorial_title(String tutorial_title) {
		this.tutorial_title = tutorial_title;
	}
	/**
	 * @return the submission_date
	 */
	public final String getSubmission_date() {
		return submission_date;
	}
	/**
	 * @param submission_date the submission_date to set
	 */
	public final void setSubmission_date(String submission_date) {
		this.submission_date = submission_date;
	}
	/**
	 * @return the tutorial_icon
	 */
	public final String getTutorial_icon() {
		return tutorial_icon;
	}
	/**
	 * @param tutorial_icon the tutorial_icon to set
	 */
	public final void setTutorial_icon(String tutorial_icon) {
		this.tutorial_icon = tutorial_icon;
	}
	/**
	 * @return the tutorial_description
	 */
	public final String getTutorial_description() {
		return tutorial_description;
	}
	/**
	 * @param tutorial_description the tutorial_description to set
	 */
	public final void setTutorial_description(String tutorial_description) {
		this.tutorial_description = tutorial_description;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Tutorial [tutorial_id=");
		builder.append(tutorial_id);
		builder.append(", ");
		if (tutorial_author != null) {
			builder.append("tutorial_author=");
			builder.append(tutorial_author);
			builder.append(", ");
		}
		if (tutorial_title != null) {
			builder.append("tutorial_title=");
			builder.append(tutorial_title);
			builder.append(", ");
		}
		if (submission_date != null) {
			builder.append("submission_date=");
			builder.append(submission_date);
			builder.append(", ");
		}
		if (tutorial_icon != null) {
			builder.append("tutorial_icon=");
			builder.append(tutorial_icon);
			builder.append(", ");
		}
		if (tutorial_description != null) {
			builder.append("tutorial_description=");
			builder.append(tutorial_description);
		}
		builder.append("]");
		return builder.toString();
	}
}
