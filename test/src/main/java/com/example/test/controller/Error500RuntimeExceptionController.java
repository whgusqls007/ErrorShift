package com.example.test.controller;

import java.awt.geom.IllegalPathStateException;
import java.lang.invoke.WrongMethodTypeException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.MalformedParametersException;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.ProviderNotFoundException;
import java.security.ProviderException;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.IllformedLocaleException;
import java.util.NoSuchElementException;
import java.util.concurrent.RejectedExecutionException;

import javax.management.JMRuntimeException;
import javax.print.attribute.UnmodifiableSetException;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.xml.crypto.NoSuchMechanismException;
import javax.xml.ws.WebServiceException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/re")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Error500RuntimeExceptionController {

    @GetMapping("/annotation-type-mismatch")
    public void getAnnotationTypeMismatchException() {
        // throw new AnnotationTypeMismatchException();
    }

    @GetMapping(value = "/arithmetic/{num}")
    public void getArithmeticException(@PathVariable int num) {
        int n = 10 / num;
    }

    @GetMapping("/array-store")
    public void getArrayStoreException() {
        throw new ArrayStoreException();
    }

    @GetMapping("/buffer-overflow")
    public void getBufferOverflowException() {
        throw new BufferOverflowException();
    }

    @GetMapping("/buffer-underflow")
    public void getBufferUnderflowException() {
        throw new BufferUnderflowException();
    }

    @GetMapping("/cannot-redo")
    public void getCannotRedoException() {
        throw new CannotRedoException();
    }

    @GetMapping("/cannot-undo")
    public void getCannotUndoException() {
        throw new CannotUndoException();
    }

    @GetMapping("/class-cast")
    public void getClassCastException() {
        throw new ClassCastException();
    }

    @GetMapping("/cmm")
    public void getCMMException() {
        // throw new CMMException();
    }

    @GetMapping("/completion")
    public void getCompletionException() {
        // throw new CompletionException();
    }

    @GetMapping("/concurrent-modification")
    public void getConcurrentModificationException() {
        throw new ConcurrentModificationException();
    }

    @GetMapping("/data-binding")
    public void getDataBindingException() {
        // throw new DataBindingException();
    }

    @GetMapping("/date-time")
    public void getDateTimeException() {
        // throw new DateTimeException();
    }

    @GetMapping("/dom")
    public void getDOMException() {
        // throw new DOMException();
    }

    @GetMapping("/empty-stack")
    public void getEmptyStackException() {
        throw new EmptyStackException();
    }

    @GetMapping("/enum-constant-not-present")
    public void getEnumConstantNotPresentException() {
        // throw new EnumConstantNotPresentException();
    }

    @GetMapping("/event")
    public void getEventException() {
        // throw new EventException();
    }

    @GetMapping("/file-system-already-exists")
    public void getFileSystemAlreadyExistsException() {
        // throw new FileAlreadyExistsException();
    }

    @GetMapping("/file-system-not-found")
    public void getFileSystemNotFoundException() {
        throw new FileSystemNotFoundException();
    }

    @GetMapping("/illegal-argument")
    public void getIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    @GetMapping("/illegal-monitor-state")
    public void getIllegalMonitorStateException() {
        throw new IllegalMonitorStateException();
    }

    @GetMapping("/illegal-path-state")
    public void getIllegalPathStateException() {
        throw new IllegalPathStateException();
    }

    @GetMapping("/illegal-state")
    public void getIllegalStateException() {
        throw new IllegalStateException();
    }

    @GetMapping("/illformed-locale")
    public void getIllformedLocaleException() {
        throw new IllformedLocaleException();
    }

    @GetMapping("/imaging-op")
    public void getImagingOpException() {
        // throw new ImagingOpException();
    }

    @GetMapping("/inclomplete-annotation")
    public void getIncompleteAnnotationException() {
        // throw new IncompleteAnnotationExceptioon();
    }

    @GetMapping("/index-out-of-bounds")
    public void getIndexOutOfBoundsException() {
        throw new IndexOutOfBoundsException();
    }

    @GetMapping("/jm-runtime")
    public void getJMRuntimeException() {
        throw new JMRuntimeException();
    }

    @GetMapping("/ls")
    public void getLSException() {
        // throw new LSException();
    }

    @GetMapping("/malformed-parameterized-type")
    public void getMalformedParameterizedTypeException() {
        throw new MalformedParameterizedTypeException();
    }

    @GetMapping("/malformed-parameters")
    public void getMalformedParametersException() {
        throw new MalformedParametersException();
    }

    @GetMapping("/mirrored-types")
    public void getMirroredTypesException() {
        // throw new MirroredTypesException();
    }

    @GetMapping("/missing-resource")
    public void getMissingResourceException() {
        // throw new MissingResourceException();
    }

    @GetMapping("/negative-array-size")
    public void getNegativeArraySizeException() {
        throw new NegativeArraySizeException();
    }

    @GetMapping("/no-such-element")
    public void getNoSuchElementException() {
        throw new NoSuchElementException();
    }

    @GetMapping("/no-such-mechanism")
    public void getNoSuchMechanismException() {
        throw new NoSuchMechanismException();
    }

    @GetMapping("/null-pointer")
    public void getNullPointerException() {
        throw new NullPointerException();
    }

    @GetMapping("/profile-data")
    public void getProfileDataException() {
        // throw new ProfileDataException();
    }

    @GetMapping("/provider")
    public void getProviderException() {
        throw new ProviderException();
    }

    @GetMapping("/provider-not-found")
    public void getProviderNotFoundException() {
        throw new ProviderNotFoundException();
    }

    @GetMapping("/raster-format")
    public void getRasterFormatException() {
        // throw new RasterFormatException();
    }

    @GetMapping("/rejected-execution")
    public void getRejectedExecutionException() {
        throw new RejectedExecutionException();
    }

    @GetMapping("/security")
    public void getSecurityException() {
        throw new SecurityException();
    }

    @GetMapping("/system")
    public void getSystemException() {
        // throw new SystemException();
    }

    @GetMapping("/type-constraint")
    public void getTypeConstraintException() {
        // throw new TypeConstraintException();
    }

    @GetMapping("/type-not-present")
    public void getTypeNotPresentException() {
        // throw new TypeNotPresentException();
    }

    @GetMapping("/unchecked-io")
    public void getUncheckedIOException() {
        // throw new UncheckedIOException();
    }

    @GetMapping("/undeclared-throwable")
    public void getUndeclaredThrowableException() {
        // throw new UndeclaredThrowableException();
    }

    @GetMapping("/unknown-entity")
    public void getUnknownEntityException() {
        // throw new UnknownEntityException();
    }

    @GetMapping("/unmodifiable-set")
    public void getUnmodifiableSetException() {
        throw new UnmodifiableSetException();
    }

    @GetMapping("/unsupported-operation")
    public void getUnsupportedOperationException() {
        throw new UnsupportedOperationException();
    }

    @GetMapping("/web-service")
    public void getWebServiceException() {
        throw new WebServiceException();
    }

    @GetMapping("/wrong-method-type")
    public void getWrongMethodTypeException() {
        throw new WrongMethodTypeException();
    }

}
