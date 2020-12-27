package utils;

import world.Block;
import world.Chunk;
import world.World;
import controllers.*;
import world.players.Player;
import world.ImgCol;
import java.util.concurrent.CopyOnWriteArrayList;
import java.io.*;


public class GenerateUtil implements Runnable
{
    public static Block kostyl_dlya_setki = null;
    static CopyOnWriteArrayList<Chunk> chunks = new CopyOnWriteArrayList<>();
    static CopyOnWriteArrayList<Block> blocks = new CopyOnWriteArrayList<>();


    // static
    //{
    //System.out.println("1");
    //generateChunks();
    //setBlocks(changeBlocks(chunks));
    //}

    public void run(){
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

    public static void save()
    {
	File world = new File("worlds/world.txt");
	try(FileWriter fileWriter = new FileWriter(world, false)){
	    fileWriter.write((int)kostyl_dlya_setki.getPosition().getX() + " " + (int) kostyl_dlya_setki.getPosition().getY()+"\n");
	for (Chunk c : chunks)
	    {
		fileWriter.append(c.getX()+" "+c.getY()+" ");
		for (Block b : c.getBlocks())
		    {
			fileWriter.append((int)b.getPosition().getX() + " "+
					 (int)b.getPosition().getY() + " ");
		    }
		fileWriter.append("\n");
		fileWriter.flush();
	    }
	fileWriter.close();
	}
	catch (IOException e)
	    {
		System.out.println("Ошибка сохранения");
	    }
    }

    public static void addBlockToChunk(Block b)
    {
	for(Chunk c : chunks)
	    {
		if ((int)b.getPosition().getX()>=c.getX()*400
		    && (int)b.getPosition().getX()<=c.getX()*400+400
		    && (int)b.getPosition().getY()>=c.getY()*400
		    && (int)b.getPosition().getY()>=c.getY()*400+400)
		    c.addBlock(b);
	    }
    }

    public static void removeBlockFromChunk(Block block)
    {
	for(Chunk c : chunks)
	    for(Block b : c.getBlocks())
		{
		    if(b==block)
			c.getBlocks().remove(b);
		}
    }

    static void generateChunks()
    {
	File world = new File("worlds/world.txt");
	if (!world.exists())
	    {
		try(
		    FileWriter fileWriter = new FileWriter(world, true);
		    )
		    {
			kostyl_dlya_setki = new Block(1,0,0);
			fileWriter.write((int)kostyl_dlya_setki.getPosition().getX() + " " + (int) kostyl_dlya_setki.getPosition().getY()+"\n");
			
			for(int x=0;x<6;x++)
			    {
				for(int y=0;y<6;y++)
				    {
					fileWriter.write(x+" "+y+" ");
					Chunk chunk = new Chunk(x,y);
					chunk.randomCreation();
					chunks.add(chunk);
					for(Block b : chunk.getBlocks())
					    {
						fileWriter.write((int)b.getPosition().getX()+" "+
								 (int)b.getPosition().getY()+" "
								 );
					    }
					fileWriter.write("\n");
					fileWriter.flush();
				    }
			    }
		    fileWriter.close();
		    }
		catch (IOException e)
		    {
			System.out.println("Ошибка с файлом карт");
		    }
		
	    }
	else{
	    try(FileReader fileReader = new FileReader(world)){
		int state = -2; // 0-x 1-y 2-nx 3-ny -2-k_x -1-k_y
		int i_k_x = 0;
		int i_k_y = 0;
		int i_x = 0;
		int i_y = 0;
		int i_nx = 0;
		int i_ny = 0;
		String k_x = "";
		String k_y = "";
		String x = "";
		String y = "";
		String nx = "";
		String ny = "";
		Chunk chunk = null;
		int c=fileReader.read();
		while (c!=-1)
		    {
			if (c>='0' && c<='9' && state==-2)
			    k_x+=(char)c;
			else if (c==' ' && state==-2)
			    {
				i_k_x=Integer.parseInt(k_x);
				state=-1;
			    }
			else if(c>='0' && c<='9' && state==-1)
			    k_y+=(char)c;
			else if(c=='\n' && state==-1)
			    {
				i_k_y=Integer.parseInt(k_y);
				state=0;
				kostyl_dlya_setki= new Block (1, i_k_x,i_k_y);
			    }
			else if(c>='0' && c<='9' && state==0)
			    {
				x= x +(char)c;
			    }
			else if(c>='0' && c<='9' && state==1)
			    y+=(char)c;
			else if(c>='0' && c<='9' && state==2)
			    nx+=(char)c;
			else if(c>='0' && c<='9' && state==3)
			    ny+=(char)c;
			else if (c==' ' && state ==0)
			    {
				state=1;
				i_x=Integer.parseInt(x);
			    }
			else if (c==' ' && state ==1)
			    {
				state=2;
				i_y=Integer.parseInt(y);
				chunk = new Chunk(i_x,i_y);
			    }
			else if (c==' ' && state ==2)
			    {
				state=3;
				i_nx=Integer.parseInt(nx);
			    }
			else if (c==' ' && state ==3)
			    {
				state=2;
				i_ny=Integer.parseInt(ny);
				chunk.addBlock(new Block(1,i_nx,i_ny)); // ВРЕМННО ОДИН
				nx="";
				ny="";
			    }
			else if (c=='\n')
			    {
				state=0;
				chunks.add(chunk);
				x="";
				y="";
			    }
			
			c=fileReader.read();
		    }
		fileReader.close();
	    }
	    catch (IOException e)
		{
		    System.out.println("Ошибка чтения карты");
		}
	}
    }
}
