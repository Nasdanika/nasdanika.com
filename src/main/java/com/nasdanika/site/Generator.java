package com.nasdanika.site;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.nasdanika.common.ExecutionException;
import org.nasdanika.common.MarkdownHelper;
import org.nasdanika.common.Util;
import org.nasdanika.drawio.Document;
import org.nasdanika.models.app.gen.AppSiteGenerator;

public class Generator {
	
	public static void main(String[] args) throws Exception {
		// Filtering index.html
		String indexHtmlTemplate = Files.readString(new File("index.html").toPath(), StandardCharsets.UTF_8);
		Document modelCoreDiagram = Document.load(new File("nasdanika.drawio"));
		Document modelTowerDiagram = Document.load(new File("model-tower.drawio"));
		String heroDiagramDescription = Files.readString(new File("hero.md").toPath(), StandardCharsets.UTF_8);;
		String towerDiagramDescription = Files.readString(new File("tower.md").toPath(), StandardCharsets.UTF_8);;
		Map<String, String> tokens = Map.of(
				"circle-diagram", modelCoreDiagram.toHtml().replace("<div class=\"mxgraph\"", "<div aria-describedby=\"hero-diagram-description\" class=\"mxgraph mx-auto\""),
				"hero-diagram-description", MarkdownHelper.INSTANCE.markdownToHtml(heroDiagramDescription),
				"tower-diagram-description", MarkdownHelper.INSTANCE.markdownToHtml(towerDiagramDescription),
				"tower-diagram", modelTowerDiagram.toHtml().replace("<div class=\"mxgraph\"", "<div class=\"mxgraph mx-auto\""));
		
		String indexHtml = Util.interpolate(indexHtmlTemplate, tokens::get);		
		Files.writeString(new File("target/index.html").toPath(), indexHtml, StandardCharsets.UTF_8);		
		
		AppSiteGenerator actionSiteGenerator = new AppSiteGenerator() {
			
			@Override
			protected boolean isDeleteOutputPath(String path) {
				return !"CNAME".equals(path) && !"favicon.ico".equals(path) && !path.startsWith("images/") && !path.startsWith("demos/") && !path.startsWith("resources/");
			}			
			
		};
		
		File rootActionFile = new File("root-action.yml").getCanonicalFile();
		String pageTemplateResource = "page-template.yml";
		URI pageTemplateURI = URI.createFileURI(new File(pageTemplateResource).getAbsolutePath());
		
		Map<String, Collection<String>> errors = actionSiteGenerator.generate(
				URI.createFileURI(rootActionFile.getAbsolutePath()).appendFragment("/"), 
				pageTemplateURI, 
				"https://nasdanika.com", 
				new File("docs"),  
				new File("target/site-work-dir"), 
				false);
				
		int errorCount = 0;
		for (Entry<String, Collection<String>> ee: errors.entrySet()) {
			System.err.println(ee.getKey());
			for (String error: ee.getValue()) {
				System.err.println("\t" + error);
				++errorCount;
			}
		}
		
		System.out.println("There are " + errorCount + " site errors");
	}
	
}
