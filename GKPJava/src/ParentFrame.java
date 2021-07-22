import java.awt.*;
import java.awt.event.*;

public class ParentFrame{
    private Frame frame = new Frame();
    private DBConnector database = new DBConnector();
    public ParentFrame(String ssid){
        this.frame = new Frame("login");
        this.frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.frame.setLocation(525, 350);
        this.frame.setSize(350,150);
        Panel panel = new Panel();
        Label label = new Label("給kid1加點數:");
        TextField textField = new TextField();
        Button button = new Button("增加");
        button.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                database.addPoint(ssid, "kid1");
            }
        });
        
        panel.add(label);
        panel.add(textField);
        panel.add(button);
        frame.add(panel);
        frame.setVisible(true);
    }
}
