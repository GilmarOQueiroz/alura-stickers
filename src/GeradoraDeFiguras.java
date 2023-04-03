import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.FileInputStream;
import java.io.InputStream;
//import java.net.URL;

import javax.imageio.ImageIO;

public class GeradoraDeFiguras {

    public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

        //InputStream inputStream = new FileInputStream(new File("imagem/filme.jpg"));
        //InputStream inputStream = new URL(
        //    "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        //    .openStream();
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 50);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);

        graphics.drawString("MELHOR", 20, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File(nomeArquivo));

    }

    //public static void main(String[] args) throws Exception {

    //    var geradora = new GeradoraDeFiguras();
    //    geradora.cria();
        
    //}
    
}
