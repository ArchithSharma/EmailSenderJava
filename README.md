# 📧 Email Sender Tool

Welcome! If you’re seeing this and starting to feel overwhelmed, don’t worry—it’s not as bad as it looks :)

This tool is a simple Java-based email sender. I originally adapted the code from a YouTube video (which I, unfortunately, can't find anymore), modifying it so that each recipient gets a **personalized message** with their name.

---

## ⚠️ Important Notes

Before you begin:
- **Google may block sign-ins** from Java apps by default. If you run into issues, it’s likely due to:
  - Syntax errors
  - Needing to enable "Less Secure App Access" in your Google Account
  - Disabling 2FA temporarily so that your password authentication goes through

Once that’s resolved, you're good to go!

---

## ✍️ Creating Your Email

1. **Write Your Message**  
   Compose your email in Gmail's editor or any rich-text editor you like.

2. **Convert to HTML**  
   Go to [wordtohtml.net](https://wordtohtml.net) and paste your message into the left box.  
   Copy the HTML output from the right box into the `email.html` file.

3. **Personalize Names**  
   In `email.html`, use the placeholder `uniqueStringName` wherever you want a recipient’s name to appear.  
   For example:
   ```html
   Dear uniqueStringName, Welcome to the Investment Club!
