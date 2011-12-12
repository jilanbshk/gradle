/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.api.internal.file;


import org.gradle.api.internal.file.archive.compression.Bzip2Archiver
import org.gradle.api.internal.file.archive.compression.GzipArchiver
import spock.lang.Specification

/**
 * by Szczepan Faber, created at: 11/24/11
 */
public class MaybeCompressedFileResourceTest extends Specification {

    def "understands file extensions"() {
        expect:
        new MaybeCompressedFileResource(new FileResource(new File("foo"))).resource instanceof FileResource
        new MaybeCompressedFileResource(new FileResource(new File("foo.tgz"))).resource instanceof GzipArchiver
        new MaybeCompressedFileResource(new FileResource(new File("foo.tbz2"))).resource instanceof Bzip2Archiver
    }
}
