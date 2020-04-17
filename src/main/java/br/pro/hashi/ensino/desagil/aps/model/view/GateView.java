package br.pro.hashi.ensino.desagil.aps.model.view;
import br.pro.hashi.ensino.desagil.aps.model.model.Gate;
import br.pro.hashi.ensino.desagil.aps.model.model.Switch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GateView extends JPanel implements ActionListener{
    private final Gate gate;

    private final JCheckBox inA;
    private final JCheckBox inB;
    private final JCheckBox out;

    private final Switch s0;
    private final Switch s1;

    public GateView(Gate gate){

        this.gate = gate;

        inA = new JCheckBox();
        inB = new JCheckBox();
        out = new JCheckBox();

        s0 = new Switch();
        s1 = new Switch();


        JLabel inLable = new JLabel("Input");
        JLabel outLable = new JLabel("Output");

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (gate.getInputSize() != 1){
            add(inA);
            add(inB);
            add(out);
            add(inLable);
            add(outLable);

            inA.addActionListener(this);
            inB.addActionListener(this);
        }else {
            add(inA);
            add(out);
            add(inLable);
            add(outLable);

            inA.addActionListener(this);
        }

        out.setEnabled(false);

        update();
    }
    private void update(){

        boolean result = gate.read();

        if (result) {
            out.setSelected(true);
        }else{
            out.setSelected(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        boolean inAState = inA.isSelected();
        boolean inBState = inB.isSelected();

        if(inAState){
            s0.turnOn();
        } else {
            s0.turnOff();
        }
        if(inBState){
            s1.turnOn();
        } else {
            s1.turnOff();
        }
        if (gate.getInputSize() != 1){
            gate.connect(0, s0);
            gate.connect(1, s1);
        } else {
            gate.connect(0,s0);
        }
        update();
    }
}
