// Proxy controlls the access to object.
// RemoteProxy & VirtualProxy & protection proxy

class ImageIconProxy implements Icon {
	ImageIcon imageIcon;
	Url url;
	Thread retreivalThread;
	boolean retrieving = false;

	public ImageIconProxy(Url url) {
		this.url = url;
	}

	public double getWidth() {
		if( imageIcon != null ) {
			return imageIcon.getWidth();
		}
		else {
			return 800;
		}
	}

	public double getHeight() {
		if( imageIcon != null ) {
			return imageIcon.getHeight();
		}
		else {
			return 600;
		}
	}

	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}

	public void paint( final Componenet c, Graphics g, int x, int y) {
		if (imageIcon != null)  {
			imageIcon.paintIcon(c,g,x,y);
		}
		else {
			g.drawString("PLeae wait...", x+300, y+200);
			if(!retrieving) {
				retreivalThread = new Thread(new Runnable(){
					public void run() {
						setImageIcon(new ImageIcon(url));
						c.repaint();
					}
				});
				retrieving = true;
				retreivalThread.start();
			}
		}

	}
}