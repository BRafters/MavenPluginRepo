import org.apache.maven.model.Dependency;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.util.List;

@Mojo(name = "dependency-counter", defaultPhase = LifecyclePhase.COMPILE) // Dependency-counter is the name of the goal, we attach it to the compile phase
public class DependencyCounter extends AbstractMojo {

    // To have access to the project information, we have to add MavenProject as a parameter
    @Parameter(defaultValue = "${project}", required = true, readonly = true)
    MavenProject project; // This object will be injected by Maven when the context is created

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        List<Dependency> dependencyList = project.getDependencies();

        // getLog() provides access to the maven log. The AbstractMojo handles its lifecycle
        getLog().info("Number of dependencies " + dependencyList.size());
    }
}
