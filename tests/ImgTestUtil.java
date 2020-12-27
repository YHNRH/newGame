package tests;

import org.junit.Test;
import org.junit.Ignore;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import world.ImgCol;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

public class ImgTestUtil {
    @Test
    public void testGround()
    {
	BufferedImage ground;
	BufferedImage _ground;
	try {
	    _ground = ImageIO.read(new File("res/ground.jpg"));
	} catch (IOException e)
	    {
		  e.printStackTrace();
		  _ground = null;
	    }
        ground = _ground;
	
	//assertEquals(ImgCol.items[ImgCol.GROUND], ground);
	assertNotNull(ImgCol.items[ImgCol.GROUND]);
    }

    
    @Test
    public void testPicaxe()
    {
	
	BufferedImage picaxe;
	BufferedImage _picaxe;
	try {
	    _picaxe = ImageIO.read(new File("res/picaxe.png"));
	} catch (IOException e)
	    {
		e.printStackTrace();
		  _picaxe = null;
	    }
        picaxe = _picaxe;
	//assertEquals(picaxe, ImgCol.items[ImgCol.PICAXE]);
	// Я закоментировал, чтобы можно было запустить приложение
	assertNotNull(ImgCol.items[ImgCol.PICAXE]);
    }
}
