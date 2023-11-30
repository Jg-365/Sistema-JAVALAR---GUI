package modificadores;

import javax.swing.ImageIcon;

public class Devs{
	private int posX;
    private int posY;
    private Boolean ativoInativo = true;
    private ImageIcon bug = new ImageIcon("C:/Users/Dr José Clerton/Downloads/PROVA-TECNICAS---PROG-main/PROVA-TECNICAS---PROG-main/visualização/Icones/developer.png");
    private Quadrantes quadrante;
    
	public Devs(int posX, int posY) {
		setPosY(posY);
		setPosX(posX);
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

	public Boolean getAtivoInativo() {
		return ativoInativo;
	}

	public void setAtivoInativo(Boolean ativoInativo) {
		this.ativoInativo = ativoInativo;
	}

	public ImageIcon getImagem() {
		return bug;
	}

	public Quadrantes getQuadrante() {
		return quadrante;
	}

	public void setQuadrante(Quadrantes quadrante) {
		this.quadrante = quadrante;
	}

}
