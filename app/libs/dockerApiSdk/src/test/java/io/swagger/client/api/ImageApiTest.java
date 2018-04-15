package io.swagger.client.api;

import io.swagger.client.ApiClient;
import io.swagger.client.model.BuildPruneResponse;
import io.swagger.client.model.ContainerConfig;
import io.swagger.client.model.ErrorResponse;
import io.swagger.client.model.HistoryResponseItem;
import io.swagger.client.model.IdResponse;
import io.swagger.client.model.Image;
import io.swagger.client.model.ImageDeleteResponseItem;
import io.swagger.client.model.ImagePruneResponse;
import io.swagger.client.model.ImageSearchResponseItem;
import io.swagger.client.model.ImageSummary;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ImageApi
 */
public class ImageApiTest {

    private ImageApi api;

    @Before
    public void setup() {
        api = new ApiClient().createService(ImageApi.class);
    }

    /**
     * Delete builder cache
     *
     * 
     */
    @Test
    public void buildPruneTest() {
        // BuildPruneResponse response = api.buildPrune();

        // TODO: test validations
    }
    /**
     * Build an image
     *
     * Build an image from a tar archive with a &#x60;Dockerfile&#x60; in it.  The &#x60;Dockerfile&#x60; specifies how the image is built from the tar archive. It is typically in the archive&#39;s root, but can be at a different path or have a different name by specifying the &#x60;dockerfile&#x60; parameter. [See the &#x60;Dockerfile&#x60; reference for more information](https://docs.docker.com/engine/reference/builder/).  The Docker daemon performs a preliminary validation of the &#x60;Dockerfile&#x60; before starting the build, and returns an error if the syntax is incorrect. After that, each instruction is run one-by-one until the ID of the new image is output.  The build is canceled if the client drops the connection by quitting or being killed. 
     */
    @Test
    public void imageBuildTest() {
        byte[] inputStream = null;
        String dockerfile = null;
        String t = null;
        String extrahosts = null;
        String remote = null;
        Boolean q = null;
        Boolean nocache = null;
        String cachefrom = null;
        String pull = null;
        Boolean rm = null;
        Boolean forcerm = null;
        Integer memory = null;
        Integer memswap = null;
        Integer cpushares = null;
        String cpusetcpus = null;
        Integer cpuperiod = null;
        Integer cpuquota = null;
        String buildargs = null;
        Integer shmsize = null;
        Boolean squash = null;
        String labels = null;
        String networkmode = null;
        String contentType = null;
        String xRegistryConfig = null;
        String platform = null;
        // Void response = api.imageBuild(inputStream, dockerfile, t, extrahosts, remote, q, nocache, cachefrom, pull, rm, forcerm, memory, memswap, cpushares, cpusetcpus, cpuperiod, cpuquota, buildargs, shmsize, squash, labels, networkmode, contentType, xRegistryConfig, platform);

        // TODO: test validations
    }
    /**
     * Create a new image from a container
     *
     * 
     */
    @Test
    public void imageCommitTest() {
        ContainerConfig containerConfig = null;
        String container = null;
        String repo = null;
        String tag = null;
        String comment = null;
        String author = null;
        Boolean pause = null;
        String changes = null;
        // IdResponse response = api.imageCommit(containerConfig, container, repo, tag, comment, author, pause, changes);

        // TODO: test validations
    }
    /**
     * Create an image
     *
     * Create an image by either pulling it from a registry or importing it.
     */
    @Test
    public void imageCreateTest() {
        String fromImage = null;
        String fromSrc = null;
        String repo = null;
        String tag = null;
        String inputImage = null;
        String xRegistryAuth = null;
        String platform = null;
        // Void response = api.imageCreate(fromImage, fromSrc, repo, tag, inputImage, xRegistryAuth, platform);

        // TODO: test validations
    }
    /**
     * Remove an image
     *
     * Remove an image, along with any untagged parent images that were referenced by that image.  Images can&#39;t be removed if they have descendant images, are being used by a running container or are being used by a build. 
     */
    @Test
    public void imageDeleteTest() {
        String name = null;
        Boolean force = null;
        Boolean noprune = null;
        // List<ImageDeleteResponseItem> response = api.imageDelete(name, force, noprune);

        // TODO: test validations
    }
    /**
     * Export an image
     *
     * Get a tarball containing all images and metadata for a repository.  If &#x60;name&#x60; is a specific name and tag (e.g. &#x60;ubuntu:latest&#x60;), then only that image (and its parents) are returned. If &#x60;name&#x60; is an image ID, similarly only that image (and its parents) are returned, but with the exclusion of the &#x60;repositories&#x60; file in the tarball, as there were no image names referenced.  ### Image tarball format  An image tarball contains one directory per image layer (named using its long ID), each containing these files:  - &#x60;VERSION&#x60;: currently &#x60;1.0&#x60; - the file format version - &#x60;json&#x60;: detailed layer information, similar to &#x60;docker inspect layer_id&#x60; - &#x60;layer.tar&#x60;: A tarfile containing the filesystem changes in this layer  The &#x60;layer.tar&#x60; file contains &#x60;aufs&#x60; style &#x60;.wh..wh.aufs&#x60; files and directories for storing attribute changes and deletions.  If the tarball defines a repository, the tarball should also include a &#x60;repositories&#x60; file at the root that contains a list of repository and tag names mapped to layer IDs.  &#x60;&#x60;&#x60;json {   \&quot;hello-world\&quot;: {     \&quot;latest\&quot;: \&quot;565a9d68a73f6706862bfe8409a7f659776d4d60a8d096eb4a3cbce6999cc2a1\&quot;   } } &#x60;&#x60;&#x60; 
     */
    @Test
    public void imageGetTest() {
        String name = null;
        // byte[] response = api.imageGet(name);

        // TODO: test validations
    }
    /**
     * Export several images
     *
     * Get a tarball containing all images and metadata for several image repositories.  For each value of the &#x60;names&#x60; parameter: if it is a specific name and tag (e.g. &#x60;ubuntu:latest&#x60;), then only that image (and its parents) are returned; if it is an image ID, similarly only that image (and its parents) are returned and there would be no names referenced in the &#39;repositories&#39; file for this image ID.  For details on the format, see [the export image endpoint](#operation/ImageGet). 
     */
    @Test
    public void imageGetAllTest() {
        List<String> names = null;
        // byte[] response = api.imageGetAll(names);

        // TODO: test validations
    }
    /**
     * Get the history of an image
     *
     * Return parent layers of an image.
     */
    @Test
    public void imageHistoryTest() {
        String name = null;
        // List<HistoryResponseItem> response = api.imageHistory(name);

        // TODO: test validations
    }
    /**
     * Inspect an image
     *
     * Return low-level information about an image.
     */
    @Test
    public void imageInspectTest() {
        String name = null;
        // Image response = api.imageInspect(name);

        // TODO: test validations
    }
    /**
     * List Images
     *
     * Returns a list of images on the server. Note that it uses a different, smaller representation of an image than inspecting a single image.
     */
    @Test
    public void imageListTest() {
        Boolean all = null;
        String filters = null;
        Boolean digests = null;
        // List<ImageSummary> response = api.imageList(all, filters, digests);

        // TODO: test validations
    }
    /**
     * Import images
     *
     * Load a set of images and tags into a repository.  For details on the format, see [the export image endpoint](#operation/ImageGet). 
     */
    @Test
    public void imageLoadTest() {
        byte[] imagesTarball = null;
        Boolean quiet = null;
        // Void response = api.imageLoad(imagesTarball, quiet);

        // TODO: test validations
    }
    /**
     * Delete unused images
     *
     * 
     */
    @Test
    public void imagePruneTest() {
        String filters = null;
        // ImagePruneResponse response = api.imagePrune(filters);

        // TODO: test validations
    }
    /**
     * Push an image
     *
     * Push an image to a registry.  If you wish to push an image on to a private registry, that image must already have a tag which references the registry. For example, &#x60;registry.example.com/myimage:latest&#x60;.  The push is cancelled if the HTTP connection is closed. 
     */
    @Test
    public void imagePushTest() {
        String name = null;
        String xRegistryAuth = null;
        String tag = null;
        // Void response = api.imagePush(name, xRegistryAuth, tag);

        // TODO: test validations
    }
    /**
     * Search images
     *
     * Search for an image on Docker Hub.
     */
    @Test
    public void imageSearchTest() {
        String term = null;
        Integer limit = null;
        String filters = null;
        // List<ImageSearchResponseItem> response = api.imageSearch(term, limit, filters);

        // TODO: test validations
    }
    /**
     * Tag an image
     *
     * Tag an image so that it becomes part of a repository.
     */
    @Test
    public void imageTagTest() {
        String name = null;
        String repo = null;
        String tag = null;
        // Void response = api.imageTag(name, repo, tag);

        // TODO: test validations
    }
}
