package com.demo.jgen;

import io.swagger.v3.oas.models.media.Schema;
import java.io.IOException;

public class JMeterTestPlanCodeGenerator implements BaseCodeGenerator {

    @Override
    public void generateCode(String packageName, String resourceName, String packageDir, Schema schema) throws IOException {
        String baseUrl = "http://localhost:8080";  // Adjust this to your actual base URL
        String testPlan = createJMeterTestPlan(packageName, resourceName, baseUrl);
        
        // Write the generated test plan to the file
        writeToFile(packageDir + resourceName + "TestPlan.jmx", testPlan);
    }

    private String createJMeterTestPlan(String packageName, String resourceName, String baseUrl) {
        String resourceNameLower = resourceName.toLowerCase();

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
          .append("<jmeterTestPlan version=\"1.2\" properties=\"5.0\" jmeter=\"5.4.3\">\n")
          .append("    <hashTree>\n")
          .append("        <TestPlan guiclass=\"TestPlanGui\" testclass=\"TestPlan\" testname=\"Test Plan\" enabled=\"true\">\n")
          .append("            <stringProp name=\"TestPlan.comments\"></stringProp>\n")
          .append("            <boolProp name=\"TestPlan.functional_mode\">false</boolProp>\n")
          .append("            <boolProp name=\"TestPlan.tearDown_on_shutdown\">true</boolProp>\n")
          .append("            <stringProp name=\"TestPlan.test_plan_notes\"></stringProp>\n")
          .append("            <boolProp name=\"TestPlan.check_for_guiclass\">true</boolProp>\n")
          .append("        </TestPlan>\n")
          .append("        <hashTree>\n")
          .append("            <ThreadGroup guiclass=\"ThreadGroupGui\" testclass=\"ThreadGroup\" testname=\"Thread Group\" enabled=\"true\">\n")
          .append("                <stringProp name=\"ThreadGroup.num_threads\">1</stringProp>\n")
          .append("                <stringProp name=\"ThreadGroup.ramp_time\">1</stringProp>\n")
          .append("                <stringProp name=\"ThreadGroup.loops\">1</stringProp>\n")
          .append("            </ThreadGroup>\n")
          .append("            <hashTree>\n")
          .append("                <!-- GET All Resource -->\n")
          .append("                <HTTPSamplerProxy guiclass=\"HttpTestSampleGui\" testclass=\"HTTPSamplerProxy\" testname=\"GET /").append(resourceNameLower).append("\" enabled=\"true\">\n")
          .append("                    <elementProp name=\"HTTPsampler.Arguments\" elementType=\"Arguments\">\n")
          .append("                        <collectionProp name=\"Arguments.arguments\"/>\n")
          .append("                    </elementProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.domain\">").append(baseUrl).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.path\">/").append(resourceNameLower).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.method\">GET</stringProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.follow_redirects\">true</boolProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.auto_redirects\">false</boolProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.use_keepalive\">true</boolProp>\n")
          .append("                </HTTPSamplerProxy>\n")
          .append("                <hashTree/>\n")
          .append("\n")
          .append("                <!-- GET Resource by ID -->\n")
          .append("                <HTTPSamplerProxy guiclass=\"HttpTestSampleGui\" testclass=\"HTTPSamplerProxy\" testname=\"GET /").append(resourceNameLower).append("/{id}\" enabled=\"true\">\n")
          .append("                    <elementProp name=\"HTTPsampler.Arguments\" elementType=\"Arguments\">\n")
          .append("                        <collectionProp name=\"Arguments.arguments\"/>\n")
          .append("                    </elementProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.domain\">").append(baseUrl).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.path\">/").append(resourceNameLower).append("/${id}</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.method\">GET</stringProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.follow_redirects\">true</boolProp>\n")
          .append("                </HTTPSamplerProxy>\n")
          .append("                <hashTree/>\n")
          .append("\n")
          .append("                <!-- POST Create Resource -->\n")
          .append("                <HTTPSamplerProxy guiclass=\"HttpTestSampleGui\" testclass=\"HTTPSamplerProxy\" testname=\"POST /").append(resourceNameLower).append("\" enabled=\"true\">\n")
          .append("                    <elementProp name=\"HTTPsampler.Arguments\" elementType=\"Arguments\">\n")
          .append("                        <collectionProp name=\"Arguments.arguments\"/>\n")
          .append("                        <elementProp name=\"Argument.value\" elementType=\"Argument\">\n")
          .append("                            <stringProp name=\"Argument.name\">application/json</stringProp>\n")
          .append("                            <stringProp name=\"Argument.value\">{}</stringProp>\n")
          .append("                        </elementProp>\n")
          .append("                    </elementProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.domain\">").append(baseUrl).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.path\">/").append(resourceNameLower).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.method\">POST</stringProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.follow_redirects\">true</boolProp>\n")
          .append("                </HTTPSamplerProxy>\n")
          .append("                <hashTree/>\n")
          .append("\n")
          .append("                <!-- PUT Update Resource -->\n")
          .append("                <HTTPSamplerProxy guiclass=\"HttpTestSampleGui\" testclass=\"HTTPSamplerProxy\" testname=\"PUT /").append(resourceNameLower).append("/{id}\" enabled=\"true\">\n")
          .append("                    <elementProp name=\"HTTPsampler.Arguments\" elementType=\"Arguments\">\n")
          .append("                        <collectionProp name=\"Arguments.arguments\"/>\n")
          .append("                        <elementProp name=\"Argument.value\" elementType=\"Argument\">\n")
          .append("                            <stringProp name=\"Argument.name\">application/json</stringProp>\n")
          .append("                            <stringProp name=\"Argument.value\">{}</stringProp>\n")
          .append("                        </elementProp>\n")
          .append("                    </elementProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.domain\">").append(baseUrl).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.path\">/").append(resourceNameLower).append("/${id}</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.method\">PUT</stringProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.follow_redirects\">true</boolProp>\n")
          .append("                </HTTPSamplerProxy>\n")
          .append("                <hashTree/>\n")
          .append("\n")
          .append("                <!-- DELETE Resource -->\n")
          .append("                <HTTPSamplerProxy guiclass=\"HttpTestSampleGui\" testclass=\"HTTPSamplerProxy\" testname=\"DELETE /").append(resourceNameLower).append("/{id}\" enabled=\"true\">\n")
          .append("                    <elementProp name=\"HTTPsampler.Arguments\" elementType=\"Arguments\">\n")
          .append("                        <collectionProp name=\"Arguments.arguments\"/>\n")
          .append("                    </elementProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.domain\">").append(baseUrl).append("</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.path\">/").append(resourceNameLower).append("/${id}</stringProp>\n")
          .append("                    <stringProp name=\"HTTPSampler.method\">DELETE</stringProp>\n")
          .append("                    <boolProp name=\"HTTPSampler.follow_redirects\">true</boolProp>\n")
          .append("                </HTTPSamplerProxy>\n")
          .append("                <hashTree/>\n")
          .append("            </hashTree>\n")
          .append("        </hashTree>\n")
          .append("    </hashTree>\n")
          .append("</jmeterTestPlan>");

        return sb.toString();
    }

    public void writeToFile(String filePath, String content) throws IOException {
        java.nio.file.Files.write(java.nio.file.Paths.get(filePath), content.getBytes());
    }
}
