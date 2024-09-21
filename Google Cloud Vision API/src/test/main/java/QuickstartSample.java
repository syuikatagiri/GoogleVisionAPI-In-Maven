package src.test.main.java;

import java.nio.file.Files; // 修正されたインポート
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

public class QuickstartSample {

    public static void main(String... args) throws Exception {
        // Initialize client that will be used to send requests.
        try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {

            System.out.println("Current working directory: " + System.getProperty("user.dir"));

            // The path to the image file to annotate
            String fileName = "./test.jpg";

            // Reads the image file into memory
            Path path = Paths.get(fileName);
            byte[] data = Files.readAllBytes(path); // 修正されたメソッド呼び出し
            ByteString imgBytes = ByteString.copyFrom(data);

            // Builds the image annotation request
            List<AnnotateImageRequest> requests = new ArrayList<>();
            Image img = Image.newBuilder().setContent(imgBytes).build();
            Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build(); // 修正されたType
            AnnotateImageRequest request =
                AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
            requests.add(request);

            // Performs label detection on the image file
            BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
            List<AnnotateImageResponse> responses = response.getResponsesList();

            for (AnnotateImageResponse res : responses) {
            	  if (res.hasError()) {
            	    System.out.format("Error: %s%n", res.getError().getMessage());
            	    return;
            	  }

            	  // テキスト検出結果を表示
            	  for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
            	    System.out.println("Text: " + annotation.getDescription());
            	    System.out.println("Position: " + annotation.getBoundingPoly());
            	  }
            	}

        }
    }
}
