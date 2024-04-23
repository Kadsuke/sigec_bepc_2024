package bf.menapln.reporting;

import bf.menapln.entity.Jury;
import bf.menapln.entity.Objet;
import bf.menapln.entity.Session;
import com.itextpdf.barcodes.BarcodeQRCode;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Canvas; 
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.List;
import javafx.embed.swing.SwingNode;
import javax.swing.JPanel;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.util.ViewerPropertiesManager;

/**
 *
 * @author kadsuke
 */
public abstract class PDF implements IEventHandler{
    protected Document document;
    protected PdfDocument pdfDocument;
    protected PdfWriter writer;
    protected PageSize pageSize = PageSize.A4;
    protected Integer topMargin = 140;
    protected Integer bottomMargin = 100;
    
    protected Paragraph timbre;
    protected Paragraph devise;
    protected Paragraph title;
    
    
    protected String path;
    protected String subFolder;
    
    protected String[] tableHeaderData;
    protected List<Objet> liste;
    
    //protected Fenetre fenetre;
    
    protected Boolean HasDefaultHeader = true;
    protected float qrcodeSize = 75f;
    
    protected String[] fonction = new String[2];
    protected String[] signataire = new String[2];
    protected String qrCodeTexte = /*this.fenetre.encrypte("bf.menapln.dsi.sigec_bac")+*/"bf.menapln.dsi.sigec_bac";
    
    private Session session;
    private Jury jury;
    
    public PDF() {
        //this.fenetre = fenetre;
        this.signataire[1]="";
        this.fonction[1]="";
    }
    
    public static SwingNode pdfViewer(PDF pdf){
        SwingController controller = new SwingController();
        SwingViewBuilder factory = new SwingViewBuilder(controller);
        JPanel viewerComponentPanel = factory.buildViewerPanel();

            // add interactive mouse link annotation support via callback
        controller.getDocumentViewController().setAnnotationCallback(
            new org.icepdf.ri.common.MyAnnotationCallback(
                controller.getDocumentViewController()));


            // Now that the GUI is all in place, we can try openning a PDF
            controller.openDocument(pdf.getPath());
            controller.setIsEmbeddedComponent(true);
            controller.getPropertiesManager().set(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_FIT, "false");
            controller.getPropertiesManager().set(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_ROTATE, "false");
            controller.getPropertiesManager().set(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_FULL_SCREEN, "false");
            controller.getPropertiesManager().set(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION_HIGHLIGHT, "false");
            controller.getPropertiesManager().set(ViewerPropertiesManager.PROPERTY_SHOW_TOOLBAR_ANNOTATION, "false");
            SwingNode swingNode = new SwingNode();
            swingNode.setContent(viewerComponentPanel);
            //swingNode.set
            return swingNode;
    }
    
    public Table header(){
        //this.setDevise(new Paragraph("Burkina Faso \n Unité - Progrès - Justice"));
            
        //this.setTimbre(new Paragraph("Ministère de l'Education Nationale, de l'Alphabétisation et de la Promotion des Langues Nationales (MENAPLN)\n ------- \n Secrétariat Général \n ------- \n Direction Générale des Examens et Concours (DGEC)"));
         
        Table tab = new Table(3);
        tab.setWidth(UnitValue.createPercentValue(100)).setTextAlignment(TextAlignment.CENTER);
        tab.addCell(new Cell().add(this.timbre).setWidth(UnitValue.createPercentValue(45)).setBorder(Border.NO_BORDER));
        tab.addCell(new Cell().add(new Paragraph()).setWidth(UnitValue.createPercentValue(15)).setBorder(Border.NO_BORDER));
        tab.addCell(new Cell().add(this.devise).setWidth(UnitValue.createPercentValue(30)).setBorder(Border.NO_BORDER));
        return tab;
    }
    
    public void setTableHeader(Table table){
        for(String str : this.tableHeaderData){
            //table.addHeaderCell(str).setBold();
            table.addHeaderCell(str);
        }
    }
    
    public abstract void setTableBody(Table table);
    
    public void body(){
      this.document.add(this.title.setTextAlignment(TextAlignment.CENTER));
    }
    
    public Table footer(){
        Table tab = new Table(3);
        tab.setWidth(UnitValue.createPercentValue(100)).setTextAlignment(TextAlignment.CENTER);
        tab.addCell(new Cell().add(new Paragraph().add(this.fonction[1]).add("\n\n\n\n").add(this.signataire[1])).setWidth(UnitValue.createPercentValue(30)).setBorder(Border.NO_BORDER));
        tab.addCell(new Cell().add(new Paragraph().add(this.qrCode())).setWidth(UnitValue.createPercentValue(35)).setBorder(Border.NO_BORDER));
        tab.addCell(new Cell().add(new Paragraph().add(this.fonction[0]).add("\n\n\n").add(this.signataire[0])).setWidth(UnitValue.createPercentValue(35)).setBorder(Border.NO_BORDER));
        return tab;
    }
    
    public Image qrCode(){
        BarcodeQRCode qrCode = new BarcodeQRCode(this.getQrCodeTexte());
        PdfFormXObject barcodeObject = qrCode.createFormXObject(ColorConstants.BLACK, this.pdfDocument);
        Image barcodeImage = new Image(barcodeObject).setWidth(this.getQrcodeSize()).setHeight(this.getQrcodeSize());
        //document.add(new Paragraph().add(barcodeImage));
        return barcodeImage;
    }
    
    public void generatePDF() throws FileNotFoundException{
        //System.out.println(this.getFonction()[1]);
        this.writer = new PdfWriter(this.path);
        this.pdfDocument = new PdfDocument(this.writer);
        this.pdfDocument.setDefaultPageSize(this.pageSize);
        this.document = new Document(this.pdfDocument);
        this.document.setTopMargin(this.topMargin);
        this.document.setBottomMargin(this.bottomMargin);
        this.pdfDocument.addEventHandler(PdfDocumentEvent.END_PAGE, this);
        //this.header();
        
        this.body();
        //this.footer();
        /*int numberOfPages = this.pdfDocument.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {

            // Write aligned text to the specified by parameters point
            this.document.showTextAligned(new Paragraph(String.format("page %s of %s", i, numberOfPages)),
                    559, 806, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
        }*/
        this.document.close();
    }

    public Paragraph getTimbre() {
        return timbre;
    }

    public void setTimbre(Paragraph timbre) {
        this.timbre = timbre;
    }

    public Paragraph getTitle() {
        return title;
    }

    public void setTitle(Paragraph title) {
        this.title = title;
    }
    
    public String setStateDirectory(){
        String userHome = System.getProperty("user.home");
        String separator = System.getProperty("file.separator");
        String desktop = "Bureau";
        File desktopPath = new File(userHome.concat(separator).concat(desktop));
        if(!desktopPath.exists()){
            desktop = "Desktop";
        }
        String basePath = userHome.concat(separator)
                .concat(desktop)
                .concat(separator)
                .concat("CEP_2024")
                .concat(separator)
                .concat(this.subFolder)
                .concat(separator);
        File directory = new File(basePath);
        if(!directory.exists()){
            directory.mkdirs();
        }
        return basePath;
    }
    
    @Override
    public void handleEvent(Event event) {
        if(this.HasDefaultHeader){
            PdfDocumentEvent documentEvent = (PdfDocumentEvent) event;
            new Canvas(documentEvent.getPage(),documentEvent.getPage().getPageSize())
            .showTextAligned(new Paragraph()
                .setWidth(documentEvent.getPage().getPageSize().getWidth()-this.document.getLeftMargin()*2)
                .add(this.header()), documentEvent.getPage().getPageSize().getX()+this.document.getLeftMargin(), documentEvent.getPage().getPageSize().getTop()-140, TextAlignment.LEFT)
            .showTextAligned(new Paragraph()
                .setWidth(documentEvent.getPage().getPageSize().getWidth()-this.document.getLeftMargin()*2)
                .add(this.footer()), documentEvent.getPage().getPageSize().getX()+this.document.getLeftMargin(), documentEvent.getPage().getPageSize().getBottom(), TextAlignment.LEFT)
            .close();
        }
    }
    
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = this.setStateDirectory().concat(path);
        /*File directory = new File(this.path);
        if(!directory.exists()){
            directory.mkdir();
        }*/
    }

    public Paragraph getDevise() {
        return devise;
    }

    public void setDevise(Paragraph devise) {
        this.devise = devise;
    }

    public List<Objet> getListe() {
        return liste;
    }

    public void setListe(List<Objet> listeCandidat) {
        this.liste = listeCandidat;
    }

    public String[] getTableHeaderData() {
        return tableHeaderData;
    }

    public void setTableHeaderData(String[] tableHeaderData) {
        this.tableHeaderData = tableHeaderData;
    }

    public String[] getFonction() {
        return fonction;
    }

    public void setFonction(String[] fonction) {
        this.fonction = fonction;
    }

    public String[] getSignataire() {
        return signataire;
    }

    public void setSignataire(String[] signataire) {
        this.signataire = signataire;
    }

    public String getQrCodeTexte() {
        return qrCodeTexte;
    }

    public void setQrCodeTexte(String qrCodeTexte) {
        this.qrCodeTexte = qrCodeTexte;
    }

    public PageSize getPageSize() {
        return pageSize;
    }

    public void setPageSize(PageSize pageSize) {
        this.pageSize = pageSize;
    }

    public float getQrcodeSize() {
        return qrcodeSize;
    }

    public void setQrcodeSize(float qrcodeSize) {
        this.qrcodeSize = qrcodeSize;
    }

    public String getSubFolder() {
        return subFolder;
    }

    public void setSubFolder(String subFolder) {
        this.subFolder = subFolder;
    }
    
    public Double decimalFormat(Double d){
        DecimalFormat df = new DecimalFormat("0.00");
        String dTostring = df.format(d);
        return Double.parseDouble(dTostring.replace(",", "."));
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Jury getJury() {
        return jury;
    }

    public void setJury(Jury jury) {
        this.jury = jury;
    }
    
}