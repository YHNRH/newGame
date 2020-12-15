package utils;

import world.Block;
import world.Chunk;
import world.World;
import controllers.*;
import world.players.Player;
import world.ImgCol;
import java.util.concurrent.CopyOnWriteArrayList;


public class GenerateUtil
{
    public static Block kostyl_dlya_setki = new Block (ImgCol.GROUND,0,0);
    static CopyOnWriteArrayList<Chunk> chunks = new CopyOnWriteArrayList<>();
    static CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();


    static
    {
	generateChunks();
	setBlocks(changeBlocks(chunks));
    }
    static public CopyOnWriteArrayList<Block> changeBlocks(CopyOnWriteArrayList<Chunk> chunks)
    {
	blocks.add(kostyl_dlya_setki);
	for(int x=0;x<3;x++)
	    for(int y=0;y<3;y++)
		{
		    //TODO!!!!!
		}
	for(int i=0;i<36;i++)
	    {
		for(Block b : chunks.get(i).getBlocks())
		    blocks.add(b); //СУПЕРВРЕМЕННО
	    }
	return blocks;
    }

    static public Block getKostyl()
    {
	return kostyl_dlya_setki;
    }


    public static void setBlocks(CopyOnWriteArrayList<Block> blocks)
    {
	Player.setBlocks(blocks);
	World.setBlocks(blocks);
	ML.setBlocks(blocks);
	KL.setBlocks(blocks);
    }

    static void generateChunks()
    {
	for(int x=0;x<6;x++)
	    {
		for(int y=0;y<6;y++)
		    {
			chunks.add(new Chunk(x,y));
			System.out.println("x = "+ x +" y = "+ y);
		    }
		
	    }
    }
}
