package visualização;

import java.awt.Color;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Celula extends JPanel {
    JLabel campoImagem;
    private ImageIcon imagem;
    private int posX;
    private int posY;
    private int ordem;
    
    public Celula(ImageIcon imagem, int posX,int posY,int ordem) {
    	this.imagem = imagem;
    	this.posX = posX;
        this.posY = posY;
        
        this.ordem = ordem;
        
        setBackground(Color.black);
        setBorder(BorderFactory.createLineBorder(Color.white));
        redimensionar(imagem);
        campoImagem = new JLabel(this.imagem);
        add(campoImagem);
    }
    
    public void setImagem(ImageIcon imagem) {
    	this.imagem = imagem;
    	if(campoImagem!=null) {
    	campoImagem.setIcon(imagem);
    	}
    }
    public ImageIcon getImagem() {
    	return imagem;
    }
    
    public void redimensionar(ImageIcon imagem) {
    	if (getImagem() != null) {
            Image img = getImagem().getImage();
            Image novaImagem = img.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            setImagem(new ImageIcon(novaImagem));
        } else {
            setImagem(null);
        }
    }

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}
	
}