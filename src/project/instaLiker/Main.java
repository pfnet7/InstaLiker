package project.instaLiker;

public class Main {

    public static void main(String[] args) {

        final DialogPanel dialogPanel = new DialogPanel();
        final InstagramPostLiker postLiker = new InstagramPostLiker(dialogPanel.getBrowserChoice());

        postLiker.loginToInstagram(dialogPanel.getLogin(), dialogPanel.getPassword());
        postLiker.likeAllPostsOf(dialogPanel.getInstagramLink());

    }

}
