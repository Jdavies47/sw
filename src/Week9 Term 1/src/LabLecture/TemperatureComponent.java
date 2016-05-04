package LabLecture;

import javax.swing.*;

/**
 * The example is taken from Jon Rowe's first year Software Workshop. In this
 * class we create a TemperatureComponent which is a JPanel to display a
 * temperature temp between a minimal (min) and maximal (max) temperature,
 * initalized to initial. On a ruler. We will add different parts to it: - The
 * model - The views (celsius and fahrenheit) - The obervers (for celsius and
 * fahrenheit)
 */
public class TemperatureComponent extends JPanel {

	public TemperatureComponent(Temperature temp, int min, int max, int initial) {
		super();

		// model
		/* TemperatureModel model = new TemperatureModel(temp); */

		// views
		/* CelsiusView celsius = new CelsiusView(model); */
		/* FahrenheitView fahrenheit = new FahrenheitView(model); */

		// make views observe model
		/* model.addObserver(celsius); */
		/* model.addObserver(fahrenheit); */

		// create control
		JSlider slider = new JSlider(min, max, initial);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing((max - min) / 4);
		slider.setPaintLabels(true);
		slider.setLabelTable(slider.createStandardLabels((max - min) / 4));

		// create listener
//		SliderListener listen = new SliderListener(model, slider);

		// make listeners listen to controls
//		slider.addChangeListener(listen);

		// place views and controls on panel
//		add(celsius);
		add(slider); // Slider in the middle
		/* add(fahrenheit); */ // Celsius degrees lowest
	}
}
