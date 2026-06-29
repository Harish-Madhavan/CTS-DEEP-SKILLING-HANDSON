interface Document {
    void open();
    void close();
}

interface WordDocument extends Document {
    void openWord();
}

interface PdfDocument extends Document {
    void openPdf();
}

interface ExcelDocument extends Document {
    void openExcel();
}

class WordDocumentImpl implements WordDocument {
    @Override
    public void open() {
        openWord();
    }

    @Override
    public void close() {
        System.out.println("Closing Word document...");
    }

    @Override
    public void openWord() {
        System.out.println("Opening Word document...");
    }
}

class PdfDocumentImpl implements PdfDocument {
    @Override
    public void open() {
        openPdf();
    }

    @Override
    public void close() {
        System.out.println("Closing PDF document...");
    }

    @Override
    public void openPdf() {
        System.out.println("Opening PDF document...");
    }
}

class ExcelDocumentImpl implements ExcelDocument {
    @Override
    public void open() {
        openExcel();
    }

    @Override
    public void close() {
        System.out.println("Closing Excel document...");
    }

    @Override
    public void openExcel() {
        System.out.println("Opening Excel document...");
    }
}

abstract class DocumentFactory {
    public abstract Document createDocument();
}

class WordDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocumentImpl();
    }
}

class PdfDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocumentImpl();
    }
}

class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocumentImpl();
    }
}
