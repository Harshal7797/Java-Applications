package ca.jrvs.apps.twitter.service;

import ca.jrvs.apps.twitter.dao.CrdRepository;
import ca.jrvs.apps.twitter.dto.Tweet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TwitterServiceTest {

    @InjectMocks
    private TwitterServiceImp service;
    
    @Mock
    private CrdRepository mockDao;

    @Test
    public void postTweet() {
        //Replaced by @Mock @InjectMocks
/*    CrdRepository mockDao = Mockito.mock(CrdRepository.class);
    TwitterService service = new TwitterServiceImp(mockDao);*/
        Tweet mockTweet = new Tweet();
        mockTweet.setText("This is a fake tweet");
        when(mockDao.create(any())).thenReturn(mockTweet);

        service.postTweet("some tweet", 50.0, 60.0);

        try {
            service.postTweet("", 50.0, 50.0);
            fail();
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void showTweet() {
        Tweet mockTweet = new Tweet();
        mockTweet.setText("This is a fake tweet");
        when(mockDao.create(any())).thenReturn(mockTweet);
        service.showTweet("50000000000000", null);

        try {
            service.showTweet("ABCD", null);
            fail();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        }
        try {
            service.showTweet("", null);
            fail();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        }
    }

    @Test
    public void deleteTweet() {
        Tweet mockTweet = new Tweet();
        mockTweet.setText("This is a fake tweet");
        when(mockDao.create(any())).thenReturn(mockTweet);

        service.deleteTweets(new String[]{"50000", "600000"});
        try {
            service.deleteTweets(new String[]{"500AA00", "600000CC"});
            fail();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        }
        try {
            service.deleteTweets(new String[]{"", ""});
            fail();
        } catch (RuntimeException e) {
            //e.printStackTrace();
        }
    }
}
